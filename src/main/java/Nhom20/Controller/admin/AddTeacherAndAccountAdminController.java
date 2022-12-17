package Nhom20.Controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Nhom20.Dao.IAccountDao;
import Nhom20.Dao.IMajorsDao;
import Nhom20.Dao.IStudentsDao;
import Nhom20.Dao.ITeachersDao;
import Nhom20.Dao.Impl.AccountDaoImpl;
import Nhom20.Dao.Impl.MajorsDaoImpl;
import Nhom20.Dao.Impl.StudentsDaoImpl;
import Nhom20.Dao.Impl.TeachersDaoImpl;
import Nhom20.Models.*;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/add"})
public class AddTeacherAndAccountAdminController extends HttpServlet{

	IMajorsDao majorsDao = new MajorsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();
	IAccountDao accountDao = new AccountDaoImpl();
	private String role = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		role = req.getParameter("role");
		if(role.equals("2")) {
			req.setAttribute("hidden", "hidden");
		}
		List<MajorsModel> lstMajor = majorsDao.getAll();
		req.setAttribute("lstMajor", lstMajor);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addAcount.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			AccountModel account = new AccountModel();
			account.setUsername(req.getParameter("email"));
			account.setPassword(req.getParameter("password"));
			account.setRole(Integer.parseInt(role));
			
			accountDao.insert(account);
			
			if(role.equals("2")) {
				//Nếu role là 2 thì thêm giảng viên
				TeachersModel teacher = new TeachersModel();
				teacher.setTeacherName(req.getParameter("name"));
				teacher.setGender(Boolean.parseBoolean(req.getParameter("gender")));
				teacher.setBirth(Date.valueOf(req.getParameter("birth")));
				teacher.setEmail(req.getParameter("email"));
				teacher.setPhone(req.getParameter("phone"));
				teacher.setMajorId(Integer.parseInt(req.getParameter("major")));
				
				teachersDao.insert(teacher);
				
				resp.sendRedirect(req.getContextPath() + "/admin/manage-teacher");
			} else if(role.equals("1")) {
				//Nếu role là 1 thì thêm sinh viên
				StudentsModel student = new StudentsModel();
				student.setStudentName(req.getParameter("name"));
				student.setGender(Boolean.parseBoolean(req.getParameter("gender")));
				student.setBirth(Date.valueOf(req.getParameter("birth")));
				student.setEmail(req.getParameter("email"));
				student.setPhone(req.getParameter("phone"));
				student.setAddress(req.getParameter("address"));
				student.setMajorId(Integer.parseInt(req.getParameter("major")));
				
				studentsDao.insert(student);
				resp.sendRedirect(req.getContextPath() + "/admin/manage-student");
			}
			
		} catch (Exception e) {
			if(role.equals("1")) {
				resp.sendRedirect(req.getContextPath() + "/admin/manage-student");
			}
			resp.sendRedirect(req.getContextPath() + "/admin/manage-teacher");
			e.printStackTrace();
		}
	}

}
