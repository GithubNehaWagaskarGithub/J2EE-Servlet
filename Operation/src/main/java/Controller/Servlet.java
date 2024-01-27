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
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------
	private void addData(HttpServletRequest req, HttpServletResponse resp) 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		double sal=Double.parseDouble(req.getParameter("sal"));
		
		DTO d1=new DTO();
		d1.setId(id);
		d1.setSal(sal);
		
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
		int id=Integer.parseInt(req.getParameter("id"));
		double sal=Double.parseDouble(req.getParameter("sal"));
		
		DTO d1=new DTO();
		d1.setId(id);
		d1.setSal(sal);
		
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

		int id=Integer.parseInt(req.getParameter("id"));
		
		DTO d1=new DTO();
		d1.setId(id);
		
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
//		ArrayList<DTO> res=d1.displayData();
		//d1.displayData();
		
//		RequestDispatcher rd=req.getRequestDispatcher("displayData.jsp");
//		req.setAttribute("ARRAYLISTDATA", res);
//		try {
//			rd.forward(req, resp);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}