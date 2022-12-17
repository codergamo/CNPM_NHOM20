package Nhom20.Controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Nhom20.Dao.IAccountDao;
import Nhom20.Dao.Impl.AccountDaoImpl;
import Nhom20.Models.AccountModel;

/**
 * Servlet implementation class ChangePasswordController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/doimatkhau","/teacher/doimatkhau"})
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	IAccountDao iacc = new AccountDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ChangePassword.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AccountModel acc = (AccountModel) session.getAttribute("account");
		String pass = request.getParameter("password");
		String newpass = request.getParameter("newpassword");
		String retypenewpass = request.getParameter("retypepassword");
		String alertmg = null;

		if (acc.getPassword().equals(pass)) {
			if (newpass.equals(retypenewpass)) {		
				iacc.editPassword(acc,newpass);
				acc.setPassword(newpass);
				alertmg = "Đổi mật khẩu thành công";
				request.setAttribute("alerts", alertmg);
			} else {
				alertmg = "Đổi mật khẩu không thành công";
				request.setAttribute("alerts", alertmg);
			}
		} else {
			alertmg = "Đổi mật khẩu không thành công";
			request.setAttribute("alerts", alertmg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ChangePassword.jsp");
		dispatcher.forward(request, response);
	}

}
