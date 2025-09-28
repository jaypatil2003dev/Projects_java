package e_com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Insert {
	public static void main(String[] args) {
		
		String driver = "org.postgresql.Driver";
		String username= "postgres";
		String password= "root";
		String url = "jdbc:postgresql://localhost:5432/e-com";
		
		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");
			
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection is created");
			
			Statement stm=con.createStatement();
			System.out.println("Statement is created");
			
			String insert="INSERT INTO product VALUES(27,'Keyboard',1000,'Intex',9,true)";
			stm.execute(insert);
			System.out.println("Record saved");
			
			con.close();
			System.out.println("Connection is closed");
			
			

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}



