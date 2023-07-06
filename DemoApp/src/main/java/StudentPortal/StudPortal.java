package StudentPortal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/StudPortal")
public class StudPortal extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name=req.getParameter("name");
		String CNo=req.getParameter("cno");
		String[] courses=req.getParameterValues("course");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1 style='color:red'>Student Name Is "+Name+"</h1>");
		pw.print("<h1 style='color:blue'>Student Contact Number Is "+CNo+"</h1>");
		pw.print("<h1>Selected Course</h1>");
		
		for(int i=0;i<courses.length;i++)
		{
			pw.print("<h3 style='color:green'>"+courses[i]+"</h3>");
		}
	}

}
