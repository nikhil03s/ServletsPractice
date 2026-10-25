package backed;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("This is first Servlet");
		
		String name= req.getParameter("name");
		String city= req.getParameter("address"); 
		
		
		 HttpSession session =req.getSession();
		 session.setAttribute("name",name);
		 session.setAttribute("city", city);
		
		
		RequestDispatcher rs= req.getRequestDispatcher("/second");
		rs.forward(req, resp);
		rs.include(req, resp);
		
		PrintWriter writers=resp.getWriter();
		writers.println("This is First Servlet Response");
		
		
	
		
	}

}
