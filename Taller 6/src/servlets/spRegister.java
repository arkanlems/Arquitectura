package servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
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
				response.sendError(response.SC_NOT_IMPLEMENTED);
			}
			
			try {
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_6", "root", "1234");			
				Statement stmt = conn.createStatement();
				
				String sql_insert_query = "insert into user (nombre, apellido, password, email, telefono)" +
						" values ('" + pam1 + "', '" + pam2 + "', '" + pam5 + "', '" + pam3 + "', " + pam4 +")";
				
				stmt.executeUpdate(sql_insert_query);
				System.out.println("insert successful!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			

	}

}
