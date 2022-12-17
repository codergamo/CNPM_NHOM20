package Nhom20.Controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Nhom20.Dao.ISignUpDao;
import Nhom20.Dao.Impl.SignUpDaoImpl;
import Nhom20.Models.SignUpModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home/RegistrationInstructions"})
public class RegistrationInstructionsController extends HttpServlet{

	ISignUpDao signUp = new SignUpDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SignUpModel sign = signUp.getLast();
		req.setAttribute("sign",sign);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/RegistrationInstructions.jsp");
		dispatcher.forward(req, resp);
	}
	
}
