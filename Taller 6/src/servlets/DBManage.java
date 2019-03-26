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
 * Servlet implementation class DBManage
 */
@WebServlet("/DBManage")
public class DBManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("solicitud").equals("registro")) {
			
			try {
				Statement stmt;
				stmt = conn.createStatement();
				String sql_insert_query = "insert into user (nombre, apellido, password, email, telefono)" +
						" values ('" + request.getAttribute("firstname") + "', '" + request.getAttribute("lastname") + "', '" + request.getAttribute("password") + "', '" + request.getAttribute("email") + "', " + request.getAttribute("cel") +")";
				
				stmt.executeUpdate(sql_insert_query);
				System.out.println("insert successful!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
