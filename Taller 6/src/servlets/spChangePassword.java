package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class spChangePassword
 */
@WebServlet("/spChangePassword")
public class spChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/ChangePassword.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pam1 = request.getParameter("Email");
		String pam2 = request.getParameter("Password");
		String pam3 = request.getParameter("ConfirmPassword");
		
		request.setAttribute("solicitud","cambiopass");
		request.setAttribute("email",pam1);
		request.setAttribute("password",pam2);
		request.setAttribute("password2",pam3);
		
		RequestDispatcher rd = request.getRequestDispatcher("./DBManage");
		rd.forward(request,response);
	}

}
