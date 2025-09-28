package e_com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws Exception {
		
		String driver = "org.postgresql.Driver";
		String username= "postgres";
		String password= "root";
		String url = "jdbc:postgresql://localhost:5432/e-com";
		
		Class.forName(driver);
		System.out.println("Driver is loaded");
		
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("Connection is created");
		
		Statement stm=con.createStatement();
		System.out.println("Statement is created");
		
		String update="UPDATE product SET price=13999 WHERE pro_id=21";
		stm.execute(update);
		System.out.println("Record saved");
		
		con.close();
		System.out.println("Connection is closed");
		
		
	}

}
