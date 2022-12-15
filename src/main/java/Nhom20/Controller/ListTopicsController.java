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

import Nhom20.Dao.ITopicDao;
import Nhom20.Dao.Impl.TopicDaoImpl;
import Nhom20.Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home/loaidetai"})
public class ListTopicsController extends HttpServlet{
	
	ITopicDao topicDao = new TopicDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<TopicModel> topics = new ArrayList<TopicModel>();
		topics = topicDao.getAll();
		req.setAttribute("topics", topics);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list-topics.jsp");
		dispatcher.forward(req, resp);
	}
}
