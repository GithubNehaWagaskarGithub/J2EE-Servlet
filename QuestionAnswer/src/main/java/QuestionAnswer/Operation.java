package QuestionAnswer;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link1")
public class Operation extends HttpServlet
{
	Connection con;
	PreparedStatement pStmt;
	ResultSet rs;
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
		String query="select * from questionanswerservlet";
		try {
			pStmt=con.prepareStatement(query);
			rs=pStmt.executeQuery();
			PrintWriter pw=resp.getWriter();
			pw.print("<table border='1' rules='all'><tr><th>QID</th><th>QUESTION</th><th>ANSWER</th><th>OPERATIONS</th></tr>");
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>");
				pw.print("<a href=''>ADD</a>  ");
				pw.print("<a href=''>DELETE</a>");
				pw.print("</td>");
				pw.print("</tr>");
			}
			pw.print("</table><br>");
			pw.print("<a href='AddQ.html'><button>ADDQue</button></a> ");
			pw.print("<a href='AddA.html'><button>ADDAns</button></a> ");
			pw.print("<a href='UpdateQ.html'><button>UPDATEQue</button></a> ");
			pw.print("<a href='UpdareA.html'><button>UPDATEAns</button></a>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
