package StudLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/StudLogin")
public class StudLogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String SetCno="9673922516";
		String SetEmail="nehawagaskar2001@gmail.com";
		String SetPass="Neha@123";
	
		String CNo=req.getParameter("cnoemail");
		String Email=req.getParameter("cnoemail");
		String Pass=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		if(CNo.equals(SetCno)&&Pass.equals(SetPass))
		{
			pw.print("<h1>Login Successfully!!</h1>");
		}
		else if(Email.equals(SetEmail)&&Pass.equals(SetPass))
		{
			pw.print("<h1>Login Successfully!!!</h1>");
		}
		else
		{
			pw.print("<h1>Invalid Data!!</h1>");
		}
	}	
}