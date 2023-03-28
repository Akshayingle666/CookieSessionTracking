package Test;
import java.sql.*;
import java.util.*;

public class RetriveProductDAO {
	public ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retrive(){
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from product50");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductBean pb=new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getLong(3));
				pb.setPqty(rs.getInt(4));
				al.add(pb);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return al;
		
		
	}

}
