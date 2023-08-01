package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/secondlink")
public class SecondClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		PrintWriter pw=resp.getWriter();
		
		HttpSession ses=req.getSession(false);
		
		if(ses!=null)
		{
			pw.print("<h1>Welcome Back"+name+"</h1>");
			pw.print("<a href='firstlink'>LOGOUT</a>");
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
