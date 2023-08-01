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
@WebServlet("/profilelink")
public class ProfileDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] ck=req.getCookies();
		PrintWriter pw=resp.getWriter();
		if(ck!=null && !ck[0].getValue().isEmpty())
		{
			pw.print("<h1>Welcome To Dashboard</h1>");
			pw.print("<h1>Welcome "+ck[0].getValue()+"</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else
		{
			pw.print("<h1>First Login then Visit Profile</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}
	
}
