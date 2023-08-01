package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/firstlink")
public class LoginClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		
		if(name.equals("Neha")&& pass.equals("Neha@123"))
		{
			HttpSession ses=req.getSession(true);
			req.getRequestDispatcher("secondlink").forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			pw.print("<h1>INVALID USERNAME OR PASSWARD</h1");
			rd.include(req, resp);
		}
	}
}
