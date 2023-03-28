package Test;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import javax.servlet.*;
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res ) 
			throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Sorry Session Expire");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else {
			c[0].setMaxAge(0);
			pw.println("Logout Successfuly <br>");}
//		}			pw.println("Sorry Session Expire");
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);
		 
	}

}
