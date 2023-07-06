package DemoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/divlink")
public class Program4 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String no1=req.getParameter("fnum");
		String no2=req.getParameter("snum");
		
		double a=Double.parseDouble(no1);
		double b=Double.parseDouble(no2);
		
		PrintWriter pw=res.getWriter();
		pw.print("Division Is :"+(a/b));
	}

}
