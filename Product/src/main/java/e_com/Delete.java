package e_com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
	public static void main(String[] args) throws Exception {
		
		String driver= "org.postgresql.Driver";
		String username= "postgres";
		String password= "root";
		String url= "jdbc:postgresql://localhost:5432/e-com";
		
		Class.forName(driver);
		System.out.println("Driver loaded successfully");
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection created");
		
		Statement stm = con.createStatement();
		System.out.println("Statement created successfully");
		
		String delete="DELETE FROM product WHERE pro_id=23";
		stm.executeLargeUpdate(delete);
		
		con.close();
		System.out.println("Connection closed");
		
	}

}
