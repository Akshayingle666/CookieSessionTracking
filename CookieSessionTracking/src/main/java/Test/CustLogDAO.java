package Test;
import java.sql.*;
import javax.servlet.http.*;

public class CustLogDAO {
	public CustomerBean cb=null;
	public CustomerBean login(HttpServletRequest req) {
       try {
    	   Connection con=DBConnection.getCon();
    	   PreparedStatement ps=con.prepareStatement("select * from custreg50 where cname=? and phno=?");
           ps.setString(1,req.getParameter("cname"));
           ps.setLong(2,Long.parseLong(req.getParameter("phno")));
           ResultSet rs=ps.executeQuery();
           if(rs.next()) {
        	 cb=new CustomerBean();
        	 cb.setCname(rs.getString(1));
        	 cb.setMid(rs.getString(2));
        	 cb.setPhno(rs.getLong(3));
        	 cb.setCity(rs.getString(4));
        	 cb.setState(rs.getString(5));
        	 cb.setPincode(rs.getInt(6));

           }
       }
       catch(Exception e) {e.printStackTrace();}
		return cb;
	}
	

}
