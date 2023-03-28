package Test;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/customer")

public class CustLogServlet extends HttpServlet{
	protected void doPost (HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		CustomerBean cb=new CustLogDAO().login(req);
		if(cb==null) {
			pw.println("invalid userid and password");
			RequestDispatcher rd=req.getRequestDispatcher("customer.html");
		    rd.include(req, res);
		}
		else {
			pw.println("welcome user "+cb.getCname()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
		    rd.include(req, res);
			
			Cookie ck= new Cookie("cname",cb.getCname());
			res.addCookie(ck);
			
		}
		
	}

}
