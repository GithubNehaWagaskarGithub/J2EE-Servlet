package DemoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addlink")
public class Program1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1=req.getParameter("fnum");
		String num2=req.getParameter("snum");
		
		double no1=Double.parseDouble(num1);
		double no2=Double.parseDouble(num2);
		
		PrintWriter pw=res.getWriter();
		pw.print("Addition Is "+(no1+no2));
	}

}
