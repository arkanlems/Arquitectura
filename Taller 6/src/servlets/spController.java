package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class spController
 */
@WebServlet("/spController")
public class spController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Connection conn = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public spController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init(ServletConfig config) throws ServletException {
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_6", "root", "1234");
			
			Statement stmt = conn.createStatement();
			
			ResultSet myRs = stmt.executeQuery("select * from user");
						
			while (myRs.next()) 
			{
				System.out.println(myRs.getString("nombre")+ ", " + myRs.getString("apellido") +
						", " + myRs.getString("password")+ ", " + myRs.getString("email") + ", " + myRs.getInt("telefono"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("Login")) 
		{
			response.sendRedirect("./spLogin");
		}
		if (opcion.equals("ChangePassword")) {
			response.sendRedirect("./spChangePassword");
		}
		if (opcion.equals("Register")) {
			response.sendRedirect("./spRegister");
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
