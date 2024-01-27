package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAOClass;
import Model.StudentClass;
@WebServlet(urlPatterns = {"/addlink"})//"/updatelink","/deletelink",/displaylink"
public class ServletController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
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
			updateData(req,resp);
			break;
		}
		case "/deletelink":
		{
			deleteData(req,resp);
			break;
		}
		case "/displaylink":
		{
			displayData(req, resp);
			break;
		}
		}
	}

	
	//-------------------------------------------------------------------------------------------------------------------
	private void addData(HttpServletRequest req, HttpServletResponse resp)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String div=req.getParameter("div");
		String add=req.getParameter("add");
		String city=req.getParameter("city");
		double per=Double.parseDouble(req.getParameter("per"));
		
		StudentClass s1=new StudentClass();
		s1.setSId(id);
		s1.setSName(name);
		s1.setSName(div);
		s1.setSName(add);
		s1.setSName(city);
		s1.setSPer(per);
		
		DAOClass d1=new DAOClass();
		int res=d1.addData(s1);
		
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
	//--------------------------------------------------------------------------------------------------------------------
	private void updateData(HttpServletRequest req, HttpServletResponse resp) 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		
		StudentClass s1=new StudentClass();
		s1.setSId(id);
		s1.setSName(name);
		
		DAOClass d1=new DAOClass();
		int res=d1.updateData(s1);
		
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
//	//----------------------------------------------------------------------------------------------------------------------
	private void deleteData(HttpServletRequest req, HttpServletResponse resp)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentClass s1=new StudentClass();
		s1.setSId(id);
		
		
		DAOClass d1=new DAOClass();
		int res=d1.deleteData(s1);
		
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

	//---------------------------------------------------------------------------------------------------------------------
	private void displayData(HttpServletRequest req, HttpServletResponse resp) 
	{
		StudentClass s1=new StudentClass();
		ArrayList<StudentClass> res=s1.displayData();
		//d1.displayData();
		
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
