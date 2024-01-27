package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Servlet;


public class DAO 
{
	static Connection con;
	static 
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
	//---------------------------------------------------------------------------------------------------------------
	public int addData(DTO d1) 
	{
		PreparedStatement pStmt;
		String query="insert into studentservlet values(?,?,?,?,?,?)";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setInt(1, d1.getRollNO());
			pStmt.setString(2, d1.getName());
			pStmt.setString(3, d1.getDiv());
			pStmt.setString(4, d1.getAddress());
			pStmt.setString(5, d1.getCity());
			pStmt.setDouble(6, d1.getMarks());
			
			int count=pStmt.executeUpdate();
			return count;		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//--------------------------------------------------------------------------------------------------------------------
	public int updateData(DTO d1) 
	{
		PreparedStatement pStmt;
		String query="update studentservlet set Marks=? where RollNo=?";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setDouble(1, d1.getMarks());
			pStmt.setInt(2, d1.getRollNO());
			
			int count=pStmt.executeUpdate();
			return count;		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//----------------------------------------------------------------------------------------------------------------------------
	public int deleteData(DTO d1) 
	{
		PreparedStatement pStmt;
		String query="delete from studentservlet where RollNo=?";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setInt(1, d1.getRollNO());
			
			int count=pStmt.executeUpdate();
			return count;		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//--------------------------------------------------------------------------------------------------------------------------
	public ArrayList<DTO> displayData() 
	{
		ResultSet rs;
		PreparedStatement stmt;
		
		ArrayList<DTO> data=new ArrayList<DTO>();
		String query="select * from studentservlet";
		
		try {
			stmt=con.prepareStatement(query);
			rs=stmt.executeQuery();
			DTO d1=null;
			while(rs.next())
			{
				d1=new DTO();
				int rollNo=rs.getInt(1);
				String name=rs.getString(2);
				String div=rs.getString(3);
				String add=rs.getString(4);
				String city=rs.getString(5);
				double marks=rs.getDouble(6);
				d1.setRollNO(rollNo);
				d1.setName(name);
				d1.setDiv(div);
				d1.setAddress(add);
				d1.setCity(city);
				d1.setMarks(marks);
				data.add(d1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	//---------------------------------------------------------------------------------------------------------------------------
	
}
