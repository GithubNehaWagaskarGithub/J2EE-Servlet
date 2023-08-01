package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link1")
public class TravelClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		double km=Double.parseDouble(req.getParameter("km"));
		double wt=Double.parseDouble(req.getParameter("wt"));
		String type=req.getParameter("type");
		
		Calculation cal=new Calculation();
		double res=cal.bill(km, wt, type);
		
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		
		req.setAttribute("KiloMeter",km);
		req.setAttribute("WaitingTime",wt);
		req.setAttribute("Type",type );
		req.setAttribute("Bill",res);
		rd.forward(req, resp);
	}
}
