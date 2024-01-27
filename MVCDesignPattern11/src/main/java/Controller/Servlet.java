package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.DTO;
@WebServlet(urlPatterns = {"/addlink","/updatelink","/deletelink","/displaylink"})
public class Servlet extends HttpServlet
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
			case "/updatelink": 
			{
				updateData(req, resp);
				break;
			}
			case "/deletelink": 
			{
				deleteData(req, resp);
				break;
			}
			case "/displaylink":
			{
				displayData(req,resp);
				break;
			}
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------
	private void addData(HttpServletRequest req, HttpServletResponse resp) 
	{
		int RollNo=Integer.parseInt(req.getParameter("no"));
		String Name=req.getParameter("name");
		String Div=req.getParameter("div");
		String Address=req.getParameter("add");
		String City=req.getParameter("city");
		double Marks=Double.parseDouble(req.getParameter("marks"));
		
		DTO d1=new DTO();
		d1.setRollNO(RollNo);
		d1.setName(Name);
		d1.setDiv(Div);
		d1.setAddress(Address);
		d1.setCity(City);
		d1.setMarks(Marks);
		
		DAO d2=new DAO();
		int res=d2.addData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("addData.jsp");
		req.setAttribute("RESULT", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------
	private void updateData(HttpServletRequest req, HttpServletResponse resp) 
	{
		int RollNo=Integer.parseInt(req.getParameter("no"));
		double Marks=Double.parseDouble(req.getParameter("marks"));
		
		DTO d1=new DTO();
		d1.setRollNO(RollNo);
		d1.setMarks(Marks);
		
		DAO d2=new DAO();
		int res=d2.updateData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("updateData.jsp");
		req.setAttribute("RESULT", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------
	private void deleteData(HttpServletRequest req, HttpServletResponse resp) 
	{

		int RollNo=Integer.parseInt(req.getParameter("no"));
		
		DTO d1=new DTO();
		d1.setRollNO(RollNo);
		
		DAO d2=new DAO();
		int res=d2.deleteData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("deleteData.jsp");
		req.setAttribute("RESULT", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------
	private void displayData(HttpServletRequest req, HttpServletResponse resp) 
	{
		DAO d1=new DAO();
		ArrayList<DTO> res=d1.displayData();
		
		RequestDispatcher rd=req.getRequestDispatcher("displayData.jsp");
		req.setAttribute("ARRAYLISTDATA", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}