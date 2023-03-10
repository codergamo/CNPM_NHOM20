package Nhom20.Controller.web;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/search","/student/search","/admin/search","/teacher/search"})
public class SearchController extends HttpServlet{
	
	ISignUpDao signUp = new SignUpDaoImpl();
	IStudentsDao students = new StudentsDaoImpl();
	ITeachersDao teachers = new TeachersDaoImpl();
	ITopicDao topics = new TopicDaoImpl();
	IPageDao page = new PageDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		
		String linkz ="./search?param_option="+ req.getParameter("param_option") + "&param_textbox=" +req.getParameter("param_textbox");
		req.setAttribute("linkz",linkz);
		
		String panel = req.getParameter("param_option");
		
		String pageIdCheck = req.getParameter("page");
		int pageid =1;
		if(pageIdCheck != null )
			pageid= Integer.parseInt(pageIdCheck);
		
		req.setAttribute("panel",panel);
		String key = req.getParameter("param_textbox");
		if(panel.equals("timkiemsinhvien"))
		{
			PageModel amountPage = page.PageStudent(key);
			
			req.setAttribute("amountPage",amountPage);
			List<StudentsModel> stu = students.getListSearh(key,pageid);
			req.setAttribute("stu",stu);
			
		}
		else if(panel.equals("timkiemgiangvien"))
		{
			PageModel amountPage = page.PageTeacher(key);
			req.setAttribute("amountPage",amountPage);
			List<TeachersModel> tea = teachers.getListSearh(key,pageid);
			req.setAttribute("tea",tea);
		}
		else
		{
			PageModel amountPage = page.PageTopic(key);
			req.setAttribute("amountPage",amountPage);
			List<TopicModel> topi =topics.getListSearh(key,pageid);
			req.setAttribute("topi",topi);
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/search.jsp");
		dispatcher.forward(req, resp);
	}
	
}