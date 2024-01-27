//package QuestionAnswer;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@WebServlet("/link3")
//public class UpdateData extends HttpServlet
//{
//	Connection con;
//	
//	@Override
//	public void init() throws ServletException 
//	{
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			try {
//				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		String Que="";
//		Que=req.getParameter("que");
//		PreparedStatement pStmt;
//		PrintWriter pw=resp.getWriter();
//		if(!Que.isEmpty())
//		{
//			String query="update questionanswerservlet set Answer where Question=?";
//			try {
//				pStmt=con.prepareStatement(query);
//				pStmt.setString(1, Que);
//				int count=pStmt.executeUpdate();
//				if(count>0)
//				{
//					pw.print("<h1>"+count+" Data Updeted</h1>");
//				}
//				else
//				{
//					pw.print("<h1>Data Not Updated</h1>");
//				}
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	}
//}
