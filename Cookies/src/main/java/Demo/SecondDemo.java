package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link2")
public class SecondDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] ck=req.getCookies();
		String username="";
		PrintWriter pw=resp.getWriter();
		for(int i=0;i<ck.length;i++)
		{
			username=ck[i].getValue();
			pw.print("<h1> Welcome Back "+username+"</h1>");
		}
		System.out.println(Arrays.toString(ck));
	}
}
