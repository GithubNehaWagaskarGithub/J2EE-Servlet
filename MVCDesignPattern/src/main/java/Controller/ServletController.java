package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/addlink","/displaylink"})
public class ServletController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String path=req.getServletPath();
		switch (path) 
		{
		case "/addlink": 
		{
			addData(req, resp);
			break;
		}
		case "/displaylink":
		{
			displayData(req, resp);
			break;
		}
		}
	}
	private void addData(HttpServletRequest req, HttpServletResponse resp) 
	{
		PrintWriter pw;
		try {
			pw=resp.getWriter();
			pw.print("<h1>User Selects Add link</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void displayData(HttpServletRequest req, HttpServletResponse resp) 
	{
		PrintWriter pw;
		try {
			pw=resp.getWriter();
			pw.print("<h1>User Selects Display link</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
