package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginlink")
public class LoginDemo extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		PrintWriter pw=resp.getWriter();
		Cookie ck=new Cookie("UserName",name);
		if(name.equals("Neha") && pass.equals("Neha@123"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			pw.print("<h1>Login Successfully</h1>");
			pw.print("<h1>Welcome"+name+"</h1>");
			rd.include(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			pw.print("<h1>Invalid Username And Passward</h1>");
			rd.include(req, resp);
		}
	}

}
