package DemoApp2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondlink")
public class EmployeeServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("sal"));
		String desig=req.getParameter("desig");
		
		EmployeeCalculation ec=new EmployeeCalculation();
		
		double increSal=ec.calculateSal(desig,sal);
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Employee Id Is"+id+"</h1>");
		pw.print("<h1>Employee Name Is"+name+"</h1>");
		pw.print("<h1>Employee Sal Is"+sal+"</h1>");
		pw.print("<h1>Employee Desig Is"+desig+"</h1>");
		pw.print("<h1>Employee Increment Sal Is"+increSal+"</h1>");
	}
}