package Nhom20.Controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Nhom20.Dao.*;
import Nhom20.Dao.Impl.*;
import Nhom20.Models.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/info" })
public class InfoStudentController extends HttpServlet {

	IStudentsDao studentsDao = new StudentsDaoImpl();
	IMajorsDao majorsDao = new MajorsDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs", signs);

		List<MajorsModel> lstMajor = majorsDao.getAll();
		req.setAttribute("lstMajor", lstMajor);

		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			
			StudentsModel student = studentsDao.findStudentByEmail(account.getUsername());

			//StudentsModel student = studentsDao.findById(2);
			req.setAttribute("student", student);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/sinhvien/info-details.jsp");
		dispatcher.forward(req, resp);
	}

}
