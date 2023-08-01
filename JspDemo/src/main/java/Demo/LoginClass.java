package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link1")
public class LoginClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		PrintWriter pw=resp.getWriter();
		
		boolean res=new Validation().validate(name, pass);
		if(res)
		{
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			req.setAttribute("USERNAME", name);
			rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
