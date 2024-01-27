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
	static Connection con=null;
	static 
	{
		try {
			Class.forName("com.cj.mysql.jdbc.Driver");
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
		String query="insert into x values(?,?)";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setInt(1, d1.getId());
			pStmt.setDouble(2, d1.getSal());
			
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
		String query="update x set Sal=? where Id=?";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setDouble(1, d1.getSal());
			pStmt.setInt(2, d1.getId());
			
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
		String query="delete from x where Id=?";
		
		try {
			pStmt=con.prepareStatement(query);
			
			pStmt.setInt(1, d1.getId());
			
			int count=pStmt.executeUpdate();
			return count;		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//--------------------------------------------------------------------------------------------------------------------------
	public ArrayList<DTO> displaydata()
	{
		ResultSet rs;
		Statement stmt;
		
		ArrayList<DTO> data=new ArrayList<DTO>();
		String query="select * from x";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			DTO d1=null;
			while(rs.next())
			{
				d1=new DTO();
				data.add(new DTO(rs.getInt(1),rs.getDouble(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
