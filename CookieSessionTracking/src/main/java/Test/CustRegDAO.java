package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustRegDAO {
	public int k;
	public int register(CustomerBean cb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into custreg50 values(?,?,?,?,?,?)");
			ps.setString(1,cb.getCname());
			ps.setString(2,cb.getMid());
			ps.setFloat(3,cb.getPhno());
            ps.setString(4,cb.getCity());
            ps.setString(5,cb.getState());
            ps.setInt(6,cb.getPincode());
            k=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
		
	}

}
