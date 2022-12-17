package Nhom20.Controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Nhom20.Dao.*;
import Nhom20.Dao.Impl.*;
import Nhom20.Models.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/register"})
public class RegisterTopicController extends HttpServlet{

	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		String email = req.getParameter("email");
		String topicId = req.getParameter("topicId");
		String leader = req.getParameter("leader");
		
		StudentsModel student = new StudentsModel();
		student = studentsDao.findStudentByEmail(email);
		
		TopicDetailsModel topicDetail = new TopicDetailsModel();
		topicDetail.setStudentId(student.getStudentId());
		topicDetail.setTopicId(Integer.parseInt(topicId));
		
		if(leader.equals("1"))
		{
			topicDetailsDao.insertLeader(topicDetail);
		}
		else if(leader.equals("0"))
		{
			topicDetailsDao.insertMenber(topicDetail);
		}
		
		resp.sendRedirect(req.getContextPath() + "/student/list-topic-register");
	}
	
}
