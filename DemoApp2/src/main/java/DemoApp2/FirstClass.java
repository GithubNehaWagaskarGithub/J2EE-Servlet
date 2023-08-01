package DemoApp2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firstlink1")
public class FirstClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String UserName=req.getParameter("username");
		String Passward=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		
		if(UserName.equals("Neha")&&(Passward.equals("Neha@123")))
		{
			pw.print("<h1>Welcome "+UserName+"</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("Employee.html");
			rd.include(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			pw.print("<h1>Invalid UserName And Passward</h1>");
			rd.include(req, resp);
		}
	}
}
