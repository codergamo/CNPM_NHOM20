package Nhom20.Controller.teacher;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class MarkController
 */
@WebServlet("/teacher/mark")
public class MarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarkController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	IMajorsDao majorsDao = new MajorsDaoImpl();
	ITopicDao topicDao = new TopicDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();

	ICouncilDao councilDao = new CouncilDaoImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String topicId = req.getParameter("id");
		// tìm dề tài
		TopicModel topic = new TopicModel();
		topic = topicDao.getById(Integer.parseInt(topicId));
		req.setAttribute("topic", topic);

		CouncilModel councilModel = councilDao.getByTopicId(topic.getTopicId());
		req.setAttribute("councilModel", councilModel);

		// tìm topicdetail theo topicId và leader
		List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
		topicdetails = topicDetailsDao.findTopicDetailByTopicId(Integer.parseInt(topicId));
		if (!topicdetails.isEmpty()) {
			if (topicdetails.get(0).getScores() < 0)
				req.setAttribute("topicdetail", topicdetails.get(0));
		}
		List<StudentsModel> students = new ArrayList<StudentsModel>();
		for (TopicDetailsModel topicDetail : topicdetails) {
			// lấy leader thành viên
			StudentsModel sd = new StudentsModel();
			sd = studentsDao.findById(topicDetail.getStudentId());
			students.add(sd);
		}

		int sl = students.size();
		req.setAttribute("sl", sl);

		req.setAttribute("students", students);

		String majorName = topicDetailsDao.findMajorNameByTopicDetail(Integer.parseInt(topicId));
		req.setAttribute("majorName", majorName);

		// lấy leader thành viên
		StudentsModel leader = new StudentsModel();
		for (TopicDetailsModel tp : topicdetails) {
			if (tp.getLeader()) {
				leader = studentsDao.findById(tp.getStudentId());
				req.setAttribute("leader", leader);
			}
		}

		// lấy thành viên

		// lấy giảng viên hd
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			
			String user = account.getUsername();
			ITeachersDao iTeachersDao = new TeachersDaoImpl();
			TeachersModel teachersModel = iTeachersDao.getByUser(user);
			req.setAttribute("teacherIn", teachersModel);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/teacher/mark.jsp");
		dispatcher.forward(req, resp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer councilId = Integer.parseInt(request.getParameter("councild"));
		Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Float scores = Float.parseFloat(request.getParameter("scores"));
		Integer topicId = Integer.parseInt(request.getParameter("topicId"));

		ICouncilDetailsDao iCouncilDetailsDao = new CouncilDetailsDaoImpl();
		iCouncilDetailsDao.updateScoresCounCilDetail(scores, councilId, teacherId, topicId);
		request.getRequestDispatcher("./listCouncil").forward(request, response);
		response.sendRedirect("./listCouncil");
	}

}
