package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name= req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String pwd=req.getParameter("password");
		
		String url="jdbc:mysql://localhost:3306/user_info";
		String user="root";
		String password="roots";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection(url, user, password);
			
			
			//Statement stm =connection.createStatement();              
			
			String sql="Insert into login_info (name,email,phone,passwords) values (?,?,?,?)";
			PreparedStatement pStatement =connection.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, email);
			pStatement.setString(3, phone);
			pStatement.setString(4, pwd);
			int rows=pStatement.executeUpdate();
			PrintWriter pw= resp.getWriter();
			if(rows!=0)
			{
				pw.println("Done");
			}else {
				pw.println("failed");
			}
			
			System.out.println("Done");
			
			pStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
