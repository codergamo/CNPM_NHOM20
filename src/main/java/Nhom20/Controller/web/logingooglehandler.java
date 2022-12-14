package Nhom20.Controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Nhom20.Models.Constants;
import Nhom20.Models.usergoogleDTO;

import org.apache.http.client.fluent.Form;

/**
 * Servlet implementation class logingooglehandler
 */
@WebServlet("/logingooglehandler")
public class logingooglehandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logingooglehandler() {
		// TODO Auto-generated constructor stub
	}

	protected usergoogleDTO processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		usergoogleDTO user = getUserInfo(accessToken);
		return user;
		
	}

	public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
						.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static usergoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		usergoogleDTO googlePojo = new Gson().fromJson(response, usergoogleDTO.class);

		return googlePojo;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usergoogleDTO user = processRequest(request, response);
		RequestDispatcher rd = null;
		//request.setCharacterEncoding("UTF-8");
		request.setAttribute("user", user.getName());
		rd = request.getRequestDispatcher("/view/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		usergoogleDTO user = processRequest(request, response);

	}
	

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
