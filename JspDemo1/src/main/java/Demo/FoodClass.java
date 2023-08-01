package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link1")
public class FoodClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qty=Integer.parseInt(req.getParameter("qty"));
		double price=Double.parseDouble(req.getParameter("price"));
		String category=req.getParameter("category");
		
		Validation vo=new Validation();
		double res=vo.Operation(qty,price,category);
		
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		req.setAttribute("PRICE",res);
		rd.forward(req, resp);
		
	}
}
