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
@WebServlet("/logoutlink")
public class LogoutDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie ck=new Cookie("UserName", "");
		ck.setMaxAge(0);
		PrintWriter pw=resp.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		pw.print("<h1>LogOut Successfully</h1>");
		rd.include(req, resp);
	}
}
