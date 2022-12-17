package Nhom20.Controller.admin;

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
@WebServlet(urlPatterns = {"/admin/manage-account"})
public class ManageAccountAdminController extends HttpServlet{

	IAccountDao accountDao = new AccountDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<AccountModel> lstAccount = new ArrayList<AccountModel>();
		lstAccount = accountDao.getAll();
		
		req.setAttribute("lstAccount", lstAccount);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/list-account.jsp");
		dispatcher.forward(req, resp);
	}
	
}
