package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.ServletController;

public class DAOClass 
{
	static Connection con;
	static
	{
		try {
			Class.forName("com.cj.mysql.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------
	public int addData(StudentClass s1) 
	{
		PreparedStatement pStmt;
		String query="insert into studentservlet values(?,?,?,?,?,?)";
		try {
			pStmt=con.prepareStatement(query);
			pStmt.setInt(1, s1.getSId());
			pStmt.setString(2, s1.getSName());
			pStmt.setString(3,s1.getSDiv());
			pStmt.setString(4,s1.getSAdd());
			pStmt.setString(5,s1.getSCity());
			pStmt.setDouble(6,s1.getSPer());
			
			int count=pStmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
//	//-----------------------------------------------------------------------------------------------------------------------------
	public int updateData(StudentClass s1) 
	{
		PreparedStatement pStmt;
		String query="update studentservlet set Name=? where RollNo=?";
		try {
			pStmt=con.prepareStatement(query);
	
			pStmt.setString(1, s1.getSName());
			pStmt.setInt(2, s1.getSId());
			
			int count=pStmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
//	//-----------------------------------------------------------------------------------------------------------------------------
	public int deleteData(StudentClass s1) 
	{
		PreparedStatement pStmt;
		String query="delete from studentservlet where RollNo=?";
		try {
			pStmt=con.prepareStatement(query);
	
			pStmt.setInt(1, s1.getSId());
			
			int count=pStmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//-----------------------------------------------------------------------------------------------------------------------------
	public ArrayList<StudentClass> displaydata()
	{
		ResultSet rs;
		Statement stmt;
		
		ArrayList<StudentClass> data=new ArrayList<StudentClass>();
		String query="select * from studentservlet";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			StudentClass d1=null;
			while(rs.next())
			{
				d1=new StudentClass();
				data.add(new StudentClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}
