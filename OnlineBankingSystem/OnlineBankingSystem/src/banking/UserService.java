package banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
	// Create new user account
	public void createUser(String name,String email, double initialBalance) {
		String query ="INSERT INTO users(name,email,balance) VALUES(?,?,?)";
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps= conn.prepareStatement(query)){
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setDouble(3,initialBalance);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Account created successfully for "+name);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//view balance of a user
	
	public void viewBalance(String email) {
		String query= "SELECT balance FROM users WHERE email = ?";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)){
			
			ps.setString(1,email);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()){
				System.out.println("Balance for "+email+" = "+ rs.getDouble("balance"));
				
			}else {
				System.out.println(" No user found with email: " + email);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
