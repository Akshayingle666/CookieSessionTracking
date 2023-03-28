package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import javax.servlet.annotation.*;
@WebServlet("/reg")

@SuppressWarnings("serial")
public class CustRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
    		throws ServletException,IOException{
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	CustomerBean cb=new CustomerBean();
    	cb.setCname(req.getParameter("cname"));
    	cb.setPhno(Long.parseLong(req.getParameter("phno")));
    	cb.setMid(req.getParameter("mid"));
    	cb.setCity(req.getParameter("city"));
    	cb.setState(req.getParameter("state"));
    	cb.setPincode(Integer.parseInt(req.getParameter("pincode")));
    	int k=new CustRegDAO().register(cb);
    	if(k>0) {
    		pw.println("new customer register successfully <br>");
    		RequestDispatcher rd=req.getRequestDispatcher("customer.html");
    		rd.include(req, res);
    		
    	}    	
}
}