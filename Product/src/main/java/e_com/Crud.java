//package e_com;
//import java.sql.*;
//
//public class Crud {
//	
//	String driver="org.postgresql.Driver";
//	String username="postgres";
//	String password="root";
//	String url="jdbc:postgresql://localhost:5432/e-com";
//	
//	//save method
//	public void save(int pro_id,String name, int price,String description,int units , boolean availability) throws Exception {
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, username, password);
//		Statement stm = con.createStatement();
//		String insert="INSERT INTO product (pro_id,name,price,description,units,availability)"+ "VALUES("+pro_id+",'"+name+"',"+price+",'"+description+"',"+units+","+(availability ? "true" : "false")+")";
//		stm.executeUpdate(insert);
//		System.out.println("Product saved with id: "+pro_id);
//		
//		stm.close();
//		con.close();
//	}
//	
//	// Fetch all method
//	
//	public void fetchAll() throws Exception {
//		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, username, password);
//		Statement stm = con.createStatement();
//		
//		String all ="SELECT * FROM product";
//		ResultSet rs=stm.executeQuery(all);
//		
//		while(rs.next()) {
//			System.out.println(rs.getInt("pro_id")+
//					           rs.getString("name")+
//					           rs.getInt("price")+
//					           rs.getString("description")+
//					           rs.getInt("units")+
//					           rs.getBoolean("availability"));	
//		}
//		con.close();
//		
//	}
//		
//		// Fetch by id
//		
//		public void fetchById(int pro_id) throws Exception {
//			
//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url, username, password);
//			Statement stm = con.createStatement();
//			
//			String byId="SELECT * FROM product WHERE pro_id ="+pro_id;
//			
//			ResultSet rs= stm.executeQuery(byId);
//			
//			if(rs.next()) {
//				System.out.println(rs.getInt("pro_id")+
//				           rs.getString("name")+
//				           rs.getInt("price")+
//				           rs.getString("description")+
//				           rs.getInt("units")+
//				           rs.getBoolean("availability"));
//			}else {
//				System.out.println("No product found");
//			}
//			con.close();
//			
//		}
//		
//		// delete method 
//		
//		public void delete(int pro_id) throws Exception {
//			
//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url, username, password);
//			Statement stm = con.createStatement();
//			
//			String del="DELETE FROM product WHERE pro_id="+pro_id;
//			
//			int rows =stm.executeUpdate(del);
//			
//			if(rows >0) {
//				System.out.println("Deleted product with pro_id"+pro_id);
//			}else {
//				System.out.println("No product found with id"+pro_id);
//			}
//			
//			con.close();
//			
//		}
//		
//		//update method
//		
//		public void update(int pro_id,int price,int units, boolean availability) throws Exception {
//			
//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url, username, password);
//			Statement stm = con.createStatement();
//			
//			String upd="UPDATE product SET price="+price+
//					                     ",units="+units+
//					                     ",availability="+availability+
//					                     " WHERE pro_id="+pro_id;
//			
//			int rows = stm.executeUpdate(upd);
//			
//			if(rows>0) {
//				System.out.println("Updated product with id: "+pro_id);
//			}else {
//				System.out.println("No product found with id; "+pro_id);
//			}
//			con.close();
//			
//		}
//		
//		public static void main(String[] args) throws Exception {
//			
//			Crud c1= new Crud();
//			
//			
//			c1.save(32, "Bottle", 700, "milton", 1, true);
////			c1.delete(27);
////			c1.fetchAll();
////			c1.update(22, 23000, 7, true);
//			
//		}
//}
