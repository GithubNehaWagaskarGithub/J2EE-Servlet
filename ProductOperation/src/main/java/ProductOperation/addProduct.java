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
@WebServlet("/addProductData")
public class addProduct extends HttpServlet{
	Connection con;
	@Override
	public void init() throws ServletException 
	{
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Pname=req.getParameter("pname");
		String PCategory=req.getParameter("pcategory");
		String PSubCategory=req.getParameter("psubcategory");
		double PPrice=Double.parseDouble(req.getParameter("pprice"));
		int PQty=Integer.parseInt(req.getParameter("pqty"));
		
		PreparedStatement pStmt;
		String inseryQuery="insert into productservlet values(?,?,?,?,?,?)";
		try 
		{
			pStmt=con.prepareStatement(inseryQuery);
			pStmt.setInt(1,0);
			pStmt.setString(2,Pname);
			pStmt.setString(3,PCategory);
			pStmt.setString(4,PSubCategory);
			pStmt.setDouble(5,PPrice);
			pStmt.setInt(6, PQty);
			int count=pStmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			if(count>0)
			{
				pw.print("<h1>"+count+"Data Added Successfully"+"</h1>");
			}
			else
			{
				pw.print("<h1>Data Not Added</h1>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
