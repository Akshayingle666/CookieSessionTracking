package Test;
import java.sql.*;
import java.io.*;

public class DBConnection {
	private static Connection con=null;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##starboy","Akshay123");
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon() {
		return con;
	}
}
