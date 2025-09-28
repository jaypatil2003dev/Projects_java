package e_com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fetch {
	public static void main(String[] args) throws Exception {
		
	
	
	String driver="org.postgresql.Driver";
	String username="postgres";
	String password="root";
	String url="jdbc:postgresql://localhost:5432/e-com";
	
	Class.forName(driver);
	
	Connection con = DriverManager.getConnection(url, username, password);
	
	Statement stm = con.createStatement();
	
	String fetch = "SELECT * FROM product";
	ResultSet rs=stm.executeQuery(fetch);
	
	
	
	while(rs.next())
	{
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getInt(5));
		System.out.println(rs.getBoolean(6));
		
	}
	
	con.close();
	System.out.println("Connection closed");
	
	}
}
