package backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/register")
public class Register extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name;
		String age;
		String address;
		
		name=req.getParameter("name");
		age=req.getParameter("age");
		address=req.getParameter("address");
//	
//		PrintWriter writer =resp.getWriter();
//		
//		writer.println("helo "+name);
//		
//		writer.close();
		
		System.out.println(name+"  "+age+"  "+address);
//		
		RequestDispatcher shows =req.getRequestDispatcher("Done.jsp");
		shows.forward(req, resp);
		shows.include(req, resp);
//
//		resp.sendRedirect("Done.jsp");
	}

}
