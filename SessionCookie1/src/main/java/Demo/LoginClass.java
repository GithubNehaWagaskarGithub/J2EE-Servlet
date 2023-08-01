package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/firstlink")
public class LoginClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession(false);
		ses.invalidate();
		resp.sendRedirect("index.html");
	}
}