package servlets;
import java.sql.*;


public class Driver {

	public static void main(String[] args) {
		try 
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_6", "root", "password");
			
			Statement stmt = conn.createStatement();
			
			ResultSet myRs = stmt.executeQuery("select * from user");
			
			
			while (myRs.next()) 
			{
				System.out.println(myRs.getString("nombre")+ ", " + myRs.getString("apellido") +
						", " + myRs.getString("password")+ ", " + myRs.getString("email") + ", " + myRs.getInt("telefono"));				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
