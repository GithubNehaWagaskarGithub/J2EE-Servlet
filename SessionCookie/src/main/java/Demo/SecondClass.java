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
		pw.print("<h1>Welcome "+name+"</h1>");
		HttpSession ses=req.getSession(false);
		pw.print("<h1>Session Id :"+ses.getId()+"</h1>");
		long l1=ses.getCreationTime();
		Date d1=new Date(l1);
		pw.print("<h1>Creation Time :"+d1+"</h1>");
		long l2=ses.getLastAccessedTime();
		Date d2=new Date(l2);
		pw.print("<h1>Access Time :"+d2+"</h1>");
	}
}
