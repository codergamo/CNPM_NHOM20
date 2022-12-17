package Nhom20.Controller.web;


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
@WebServlet(urlPatterns = {"/list-topic","/admin/list-topic","/student/list-topic","/teacher/list-topic"})
public class ListTopicsController extends HttpServlet{
	
	ISignUpDao signUp = new SignUpDaoImpl();
	ITopicDao topicDao = new TopicDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		
		List<TopicModel> topics = new ArrayList<TopicModel>();
		topics = topicDao.getAll();
		req.setAttribute("topics", topics);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list-topics.jsp");
		dispatcher.forward(req, resp);
	}
}
