package DemoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/mullink")
public class Program3 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1=req.getParameter("no1");
		String num2=req.getParameter("no2");
		
		double a=Double.parseDouble(num1);
		double b=Double.parseDouble(num2);
		
		PrintWriter pw=res.getWriter();
		pw.print("Multiplication Is "+(a*b));
	}

}
