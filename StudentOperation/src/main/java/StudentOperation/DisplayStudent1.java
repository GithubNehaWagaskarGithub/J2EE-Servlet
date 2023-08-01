package StudentOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/displayStudentData1")
public class DisplayStudent1 extends HttpServlet
{
	Connection con;
	
	@Override
	public void init() throws ServletException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int RollNo=Integer.parseInt(req.getParameter("rollno"));
		
		PreparedStatement pStmt;
		ResultSet rs;
		String displayQuery1="select * from studentservlet where RollNo=?";
		try {
			pStmt=con.prepareStatement(displayQuery1);
			pStmt.setInt(1,RollNo );
			rs=pStmt.executeQuery();
			PrintWriter pw=resp.getWriter();
			
			while(rs.next())
			{
				pw.print("<table border='1' rules='all'><tr><th>Roll No</th><th>Name</th><th>Division</th><th>Address</th><th>City</th><th>Marks</th></tr>");
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>"+rs.getString(4)+"</td>");
				pw.print("<td>"+rs.getString(5)+"</td>");
				pw.print("<td>"+rs.getDouble(6)+"</td>");
				pw.print("</tr>");
				pw.print("</table>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

