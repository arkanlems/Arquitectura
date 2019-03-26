package servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class spRegister
 */
@WebServlet("/spRegister")
public class spRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public spRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Connection conn;
	
	public void init(ServletConfig config) throws ServletException {
	
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/Register.html");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String pam1 = request.getParameter("firstname");
			String pam2 = request.getParameter("lastname");
			String pam3 = request.getParameter("Email");
			String pam4 = request.getParameter("Cel");
			String pam5 = request.getParameter("Password");
			
			if (pam1.isEmpty() || pam2.isEmpty() || pam3.isEmpty() || pam4.isEmpty() || pam5.isEmpty()) {
				response.sendError(response.SC_NO_CONTENT);
			}
			
			request.setAttribute("solicitud","registro");	
			request.setAttribute("firstname",pam1);	
			request.setAttribute("lastname",pam2);		
			request.setAttribute("email",pam3);		
			request.setAttribute("cel",pam4);		
			request.setAttribute("password",pam5);	
			
			RequestDispatcher rd = request.getRequestDispatcher("./DBManage");
			rd.forward(request,response);

	}

}
