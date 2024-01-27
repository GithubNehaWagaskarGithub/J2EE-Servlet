package ProductOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateProductData")
public class updateProduct extends HttpServlet{
	Connection con;
	PreparedStatement pStmt;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		String pId="",pName="",pCategory="",pSubCategory="",pPrice="",pqty="";
		pId=req.getParameter("pid");
		pName=req.getParameter("pname");
		pCategory=req.getParameter("pcategory");
		pSubCategory=req.getParameter("psubcategory");
		pPrice=req.getParameter("pprice");
		pqty=req.getParameter("pqty");
		
		int Id=Integer.parseInt(req.getParameter("pid"));
		PrintWriter pw=resp.getWriter();
		
		PreparedStatement pStmt=null;
		if(!pName.isEmpty())
		{
			String updatequery1="update productservlet set Name=? where Id=?";
			try {
				pStmt=con.prepareStatement(updatequery1);
				pStmt.setString(1,pName);
				pStmt.setInt(2, Id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>"+count+" Name Updated Successfully "+"</h1>");
				}
				else
				{
					pw.print("<h1>Data Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!pCategory.isEmpty())
		{
			String updatequery2="update productservlet set Category=? where Id=?";
			try {
				pStmt=con.prepareStatement(updatequery2);
				pStmt.setString(1,pCategory);
				pStmt.setInt(2, Id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>"+count+" Category Updated Successfully "+"</h1>");
				}
				else
				{
					pw.print("<h1>Data Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!pSubCategory.isEmpty())
		{
			String updatequery3="update productservlet set Sub_Category=? where Id=?";
			try {
				pStmt=con.prepareStatement(updatequery3);
				pStmt.setString(1,pSubCategory);
				pStmt.setInt(2, Id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>"+count+" Sub_Category Updated Successfully "+"</h1>");
				}
				else
				{
					pw.print("<h1>Data Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!pPrice.isEmpty())
		{
			String updateQuery4="update productservlet set Price=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateQuery4);
				pStmt.setDouble(1,Double.parseDouble(pPrice));
				pStmt.setInt(2, Id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>"+count+" Price Updated Successfully "+"</h1>");
				}
				else
				{
					pw.print("<h1>Data Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String updateQuery5="update productservlet set Qty=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateQuery5);
				pStmt.setInt(1,Integer.parseInt(pqty));
				pStmt.setInt(2, Id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>"+count+" Qty Updated Successfully "+"</h1>");
				}
				else
				{
					pw.print("<h1>Data Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
