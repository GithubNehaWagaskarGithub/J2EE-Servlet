package StudentOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addStudentData")
public class AddStudent extends HttpServlet
{
	Connection con;
	PreparedStatement pStmt;
	@Override
	public void init() throws ServletException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int RollNo=Integer.parseInt(req.getParameter("rollno"));
		String Name=req.getParameter("name");
		char Div=req.getParameter("div").charAt(0);
		String Address=req.getParameter("address");
		String City=req.getParameter("city");
		double Marks=Double.parseDouble(req.getParameter("marks"));
		
		String insertQuery="insert into studentservlet values(?,?,?,?,?,?)";
		try {
			pStmt=con.prepareStatement(insertQuery);
			pStmt.setInt(1,RollNo);
			pStmt.setString(2,Name);
			pStmt.setString(3,Div+"");
			pStmt.setString(4,Address);
			pStmt.setString(5,City);
			pStmt.setDouble(6, Marks);
			int count=pStmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			if(count>0)
			{
				pw.print("<h1>"+count+" Data Added Successfully"+"</h1>");
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
