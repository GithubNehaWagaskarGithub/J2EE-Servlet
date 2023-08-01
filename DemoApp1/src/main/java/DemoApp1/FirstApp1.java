//package DemoApp1;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@WebServlet("/firstlink1")
//public class FirstApp1 extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String UserName=req.getParameter("username");
//		PrintWriter pw=resp.getWriter();
//		pw.print("<h1>Welcome"+UserName+"</h1>");
//		
//		RequestDispatcher rd=req.getRequestDispatcher("/secondlink");
//		rd.forward(req,resp);//forward method is used for to provide link between two Different Application
//		
//		pw.print("<h1>Thank u for visiting</h1>");
//	}
//
//}