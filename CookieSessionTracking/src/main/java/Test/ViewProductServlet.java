package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/view")

public class ViewProductServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Session expire");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else {
			String cName=c[0].getValue();
			pw.println(cName);
			pw.println("page of customer "+cName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			ArrayList<ProductBean> al=new RetriveProductDAO().retrive();
			if(al.size()==0) {
				pw.println("<br> Product not available<br>");
			}
			else {
				Iterator<ProductBean> it=al.iterator();
				while(it.hasNext()) {
					ProductBean pb=(ProductBean)it.next();
					pw.println("<br>"+pb.getPcode()+"&nbsp&nbsp"
							+pb.getPname()+"&nbsp&nbsp"+pb.getPprice()
							+"&nbsp"+pb.getPqty()+"&nbsp&nbsp");
				}
			}
		}
	 }

}
