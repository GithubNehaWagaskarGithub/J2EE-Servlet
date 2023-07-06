package Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpInfolink")
public class EmpInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id=req.getParameter("id");
		String Name=req.getParameter("name");
		String Sal=req.getParameter("sal");
		String Hra=req.getParameter("hra");
		String Pf=req.getParameter("pf");
		String Desig=req.getParameter("desig");
		
		double basicsal=Double.parseDouble(Sal);
		double hra=Double.parseDouble(Hra);
		double pf=Double.parseDouble(Pf);
		
		double YearlySal=(basicsal+hra+pf)*12;
		
		double incrementedSalary=0.0;
		PrintWriter pw=resp.getWriter();
		pw.print("<h1 style='color:blue'>Emp Id Is "+Id+"</h1>");
		pw.print("<h1 style='color:red'>Emp Name Is "+Name+"</h1>");
		pw.print("<h1 style='color:green'>Emp Sal Is "+Sal+"</h1>");
		pw.print("<h1 style='color:pink'>Emp HRA Is "+Hra+"</h1>");
		pw.print("<h1 style='color:yellow'>Emp PF Is "+Pf+"</h1>");
		
		
		if(Desig.equals("dev"))
		{
			incrementedSalary=YearlySal+(YearlySal*0.3);
			pw.print("<h1 style='color:Violet'>Emp Yearly Sal Is "+YearlySal+"</h1>");
			pw.print("<h1 style='color:green'>Incremented Salary of Developer Is "+incrementedSalary+"</h1>");
		}
		else if (Desig.equals("test")) 
		{
			incrementedSalary=YearlySal+(YearlySal*0.2);
			pw.print("<h1 style='color:Violet'>Emp Yearly Sal Is "+YearlySal+"</h1>");
			pw.print("<h1 style='color:green'>Incremented Salary of Tester Is "+incrementedSalary+"</h1>");
		}
		else {
			incrementedSalary=YearlySal+(YearlySal*0.1);
			pw.print("<h1 style='color:Violet'>Emp Yearly Sal Is "+YearlySal+"</h1>");
			pw.print("<h1 style='color:green'>Incremented Salary of Hr Is "+incrementedSalary+"</h1>");
		}
	}
}