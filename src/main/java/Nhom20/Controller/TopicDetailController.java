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

import Nhom20.Dao.IMajorsDao;
import Nhom20.Dao.IStudentsDao;
import Nhom20.Dao.ITeachersDao;
import Nhom20.Dao.ITopicDao;
import Nhom20.Dao.ITopicDetailsDao;
import Nhom20.Dao.Impl.MajorsDaoImpl;
import Nhom20.Dao.Impl.StudentsDaoImpl;
import Nhom20.Dao.Impl.TeachersDaoImpl;
import Nhom20.Dao.Impl.TopicDaoImpl;
import Nhom20.Dao.Impl.TopicDetailsDaoImpl;
import Nhom20.Models.MajorsModel;
import Nhom20.Models.StudentsModel;
import Nhom20.Models.TeachersModel;
import Nhom20.Models.TopicDetailsModel;
import Nhom20.Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home/chitietdetai"})
public class TopicDetailController extends HttpServlet{

	IMajorsDao majorsDao = new MajorsDaoImpl();
	ITopicDao topicDao = new TopicDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//lấy topicId
		String topicId = req.getParameter("id");
		//tìm dề tài
		TopicModel topic = new TopicModel();
		topic = topicDao.findById(Integer.parseInt(topicId));
		req.setAttribute("topic", topic);
		
		
		//tìm topicdetail theo topicId và leader
		List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
		topicdetails = topicDetailsDao.findTopicDetailByTopicId(Integer.parseInt(topicId));
		req.setAttribute("topicdetail", topicdetails.get(0));
		List<StudentsModel> students = new ArrayList<StudentsModel>();
		
		for (TopicDetailsModel topicDetail : topicdetails) {
			//lấy leader thành viên
			StudentsModel sd = new StudentsModel();
			sd = studentsDao.findById(topicDetail.getStudentId());
			students.add(sd);
		}
		
		int sl = students.size();
		req.setAttribute("sl", sl);
		
		req.setAttribute("students", students);
		
		String majorName = topicDetailsDao.findMajorNameByTopicDetail(Integer.parseInt(topicId));
		req.setAttribute("majorName", majorName);
		
		
		//lấy leader thành viên
		StudentsModel leader = new StudentsModel();
		for (TopicDetailsModel tp : topicdetails) {
			if(tp.getLeader())
			{
				leader = studentsDao.findById(tp.getStudentId());
				req.setAttribute("leader", leader);
			}
		}
		
		
		//lấy thành viên
;
		
		//lấy giảng viên hd
		TeachersModel teacherIn = new TeachersModel();
		teacherIn = teachersDao.findById(topic.getTeacherId());
		req.setAttribute("teacherIn", teacherIn);
		
		//lay gv phan bien
//		TeachersModel teacherPb = new TeachersModel();
//		teacherIn = teachersDao.findById(topic.getTeacherId());
//		req.setAttribute("teacherIn", teacherIn);
		
//		List<TopicModel> topics = new ArrayList<TopicModel>();
//		topics = topicDao.getAll();
//		req.setAttribute("topics", topics);
		
//		List<MajorsModel> majors = new ArrayList<MajorsModel>();
//		majors = majorsDao.getAll();
//		req.setAttribute("majors", majors);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/topic-detail.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
