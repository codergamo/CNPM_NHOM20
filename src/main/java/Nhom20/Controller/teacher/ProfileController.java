package Nhom20.Controller.teacher;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ProfileController
 */
@WebServlet("/teacher/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		request.setAttribute("signs",signs);
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			
			// email = 20110300@student.hcmute.edu.vn
			String user = account.getUsername();
			ITeachersDao iTeachersDao = new TeachersDaoImpl();
			TeachersModel teachersModel = iTeachersDao.getByUser(user);

			IMajorsDao majorsDao = new MajorsDaoImpl();
			request.setAttribute("teacher", teachersModel);
			request.setAttribute("majorsDao", majorsDao);
			request.getRequestDispatcher("/view/teacher/profile.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
