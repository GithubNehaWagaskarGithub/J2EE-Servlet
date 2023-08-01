package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link")
public class ProductClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname=req.getParameter("name");
		String pprice=req.getParameter("price");
		String add=req.getParameter("add");
		String view=req.getParameter("view");
		
		PrintWriter pw=resp.getWriter();
		
		if(add!=null)
		{
			Cookie temp=new Cookie(pname,pprice);
			resp.addCookie(temp);
			resp.sendRedirect("index.html");
		}
		else
		{
			Cookie[] c1=req.getCookies();
			for(int i=0;i<c1.length;i++)
			{
				pw.print("<h1>Product Name "+c1[i].getName()+"\t Product Price "+c1[i].getValue()+"</h1>");
			}
		}
	}
}
