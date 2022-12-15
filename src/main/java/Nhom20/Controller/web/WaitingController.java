package Nhom20.Controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Nhom20.Models.AccountModel;
import Nhom20.Models.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("account")!= null) {
			AccountModel u = (AccountModel) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if(u.getRole()==1) {
				resp.sendRedirect(req.getContextPath()+ "/admin");
			}else if(u.getRole() == 2) {
				resp.sendRedirect(req.getContextPath()+ "/student/home");
			}else {
				resp.sendRedirect(req.getContextPath()+ "/teacher/home");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+ "/login");
		}
	}
}
