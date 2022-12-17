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
@WebServlet(urlPatterns = {"/home/TinTuGiaoVu"})
public class TinTuGiaoVuController extends HttpServlet{

	
	ISignUpDao signUp = new SignUpDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		
		int id = Integer.parseInt(req.getParameter("id"));
		SignUpModel sign = signUp.get(id);
		req.setAttribute("sign",sign);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/TinTuGiaoVu.jsp");
		dispatcher.forward(req, resp);
	}
	
}
