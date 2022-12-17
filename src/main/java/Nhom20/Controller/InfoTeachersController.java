package Nhom20.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Nhom20.Dao.*;
import Nhom20.Dao.Impl.*;
import Nhom20.Models.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/info-teacher","/teacher/info-teacher"})
public class InfoTeachersController extends HttpServlet{

	ITeachersDao teacherDao = new TeachersDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TeachersModel> lstTeacher = new ArrayList<TeachersModel>();
		lstTeacher = teacherDao.getAllByAdmin();
		
		req.setAttribute("lstTeacher", lstTeacher);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list-teacher.jsp");
		dispatcher.forward(req, resp);
	}
}
