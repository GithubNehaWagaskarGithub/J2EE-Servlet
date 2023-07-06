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
		int Ch=Integer.parseInt(req.getParameter("ch"));
		switch(Ch)
		{
			case 1:
				int Pid1=Integer.parseInt(req.getParameter("pid"));
				String Pname1=req.getParameter("pname");
				boolean PCategory1=req.getParameter("pcategory").isEmpty();
				boolean PSubCategory1=req.getParameter("psubcategory").isEmpty();
				boolean PPrice1=req.getParameter("pprice").isEmpty();
				boolean PQty1=req.getParameter("pqty").isEmpty();
				
				String updateQuery1="update productservlet set Name=? where Id=?";
				
				try {
					pStmt=con.prepareStatement(updateQuery1);
					pStmt.setString(1,Pname1);
					pStmt.setInt(2, Pid1);
					int count=pStmt.executeUpdate();
					PrintWriter pw=resp.getWriter();
					if(count>0)
					{
						pw.print("<h1>"+count+" Product Name Updated Successfully"+"</h1>");
					}
					else
					{
						pw.print("<h1>Product Name Not Updated</h1>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				int Pid2=Integer.parseInt(req.getParameter("pid"));
				boolean Pname2=req.getParameter("pname").isEmpty();
				String PCategory2=req.getParameter("pcategory");
				boolean PSubCategory2=req.getParameter("psubcategory").isEmpty();
				boolean PPrice2=req.getParameter("pprice").isEmpty();
				boolean PQty2=req.getParameter("pqty").isEmpty();
				
				String updateQuery2="update productservlet set Category=? where Id=?";
				
				try {
					pStmt=con.prepareStatement(updateQuery2);
					pStmt.setString(1,PCategory2);
					pStmt.setInt(2, Pid2);
					int count=pStmt.executeUpdate();
					PrintWriter pw=resp.getWriter();
					if(count>0)
					{
						pw.print("<h1>"+count+" Product Category Updated Successfully"+"</h1>");
					}
					else
					{
						pw.print("<h1>Product Category Not Updated</h1>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				int Pid3=Integer.parseInt(req.getParameter("pid"));
				boolean Pname3=req.getParameter("pname").isEmpty();
				boolean PCategory3=req.getParameter("pcategory").isEmpty();
				String PSubCategory3=req.getParameter("psubcategory");
				boolean PPrice3=req.getParameter("pprice").isEmpty();
				boolean PQty3=req.getParameter("pqty").isEmpty();
				
				String updateQuery3="update productservlet set Sub_Category=? where Id=?";
				
				try {
					pStmt=con.prepareStatement(updateQuery3);
					pStmt.setString(1,PSubCategory3);
					pStmt.setInt(2, Pid3);
					int count=pStmt.executeUpdate();
					PrintWriter pw=resp.getWriter();
					if(count>0)
					{
						pw.print("<h1>"+count+" Product Sub_Category Updated Successfully"+"</h1>");
					}
					else
					{
						pw.print("<h1>Product Sub_Category Not Updated</h1>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	
			case 4:
				int Pid4=Integer.parseInt(req.getParameter("pid"));
				boolean Pname4=req.getParameter("pname").isEmpty();
				boolean PCategory4=req.getParameter("pcategory").isEmpty();
				boolean PSubCategory4=req.getParameter("psubcategory").isEmpty();
				double PPrice4=Double.parseDouble(req.getParameter("pprice"));
				boolean PQty4=req.getParameter("pqty").isEmpty();
				
				String updateQuery4="update productservlet set Price=? where Id=?";
				
				try {
					pStmt=con.prepareStatement(updateQuery4);
					pStmt.setDouble(1,PPrice4);
					pStmt.setInt(2, Pid4);
					int count=pStmt.executeUpdate();
					PrintWriter pw=resp.getWriter();
					if(count>0)
					{
						pw.print("<h1>"+count+" Product Price Updated Successfully"+"</h1>");
					}
					else
					{
						pw.print("<h1>Product Price Not Updated</h1>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	
			case 5:
				int Pid5=Integer.parseInt(req.getParameter("pid"));
				boolean Pname5=req.getParameter("pname").isEmpty();
				boolean PCategory5=req.getParameter("pcategory").isEmpty();
				boolean PSubCategory5=req.getParameter("psubcategory").isEmpty();
				boolean PPrice5=req.getParameter("pprice").isEmpty();
				int PQty5=Integer.parseInt(req.getParameter("pqty"));
				
				String updateQuery5="update productservlet set Qty=? where Id=?";
				
				try {
					pStmt=con.prepareStatement(updateQuery5);
					pStmt.setInt(1,PQty5);
					pStmt.setInt(2, Pid5);
					int count=pStmt.executeUpdate();
					PrintWriter pw=resp.getWriter();
					if(count>0)
					{
						pw.print("<h1>"+count+" Product Qty Updated Successfully"+"</h1>");
					}
					else
					{
						pw.print("<h1>Product Qty Not Updated</h1>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	
			case 6:
				PrintWriter pw=resp.getWriter();
				pw.print("<h1>Invalid Choice</h1>");
				break;
		}
	}
}
