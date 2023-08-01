package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link1")
public class FirstDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Welcome "+username+"</h1>");
		
		Cookie ck=new Cookie("UserName",username);
		resp.addCookie(ck);
		
		pw.print("<a href='link2'>secondlink</a>");
	}
}
