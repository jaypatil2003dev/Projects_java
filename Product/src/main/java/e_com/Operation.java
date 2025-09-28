package e_com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operation {
	
	String url="jdbc:postgresql://localhost:5432/e-com?user=postgres&password=root";
	String driver="org.postgresql.Driver";
	
	// save
	public void save(int pro_id,String name,int price, String description, int units, boolean availability) throws Exception {

		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url);
		
		String insert="INSERT INTO product VALUES(?,?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(insert);
		pstm.setInt(1, pro_id);
		pstm.setString(2, name);
		pstm.setInt(3,price);
		pstm.setString(4, description);
		pstm.setInt(5, units);
		pstm.setBoolean(6, availability);
		
		pstm.execute();
		
		con.close();
		
		System.out.println("Record saved");
			
	}
	
	//delete
	public void delete(int pro_id) throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		
		String delete="DELETE FROM product WHERE pro_id=?";
		PreparedStatement pstm = con.prepareStatement(delete);
		
		pstm.setInt(1, pro_id);
		pstm.execute();
		
		con.close();
		
		System.out.println("Record deleted successfully");
		
	}
	// update
	public void update(int pro_id,int price) throws Exception {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		
		String update="UPDATE product SET price=? WHERE pro_id=?";
		PreparedStatement pstm = con.prepareStatement(update);
		
		pstm.setInt(1,price);
		pstm.setInt(2, pro_id);
		
		pstm.execute();
		con.close();
		
		System.out.println("record updated");
		
	}
	
	// fetch all
	
	public void fetchAll() throws Exception {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		
		String fetchall="SELECT * FROM product";
		PreparedStatement pstm = con.prepareStatement(fetchall);
		
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println(
			          rs.getInt(1)+
			          rs.getString(2)+
			          rs.getInt(3)+
			          rs.getString(4)+
			          rs.getInt(5)+
			          rs.getBoolean(6));
		}
		con.close();
		System.out.println();
		
	}
	
	public void fetchById(int pro_id) throws Exception {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		
		String byid="SELECT * FROM product WHERE pro_id="+pro_id;
		PreparedStatement pstm = con.prepareStatement(byid);

		ResultSet rs=pstm.executeQuery();
		
		if(rs.next()) {
			System.out.println(
			          rs.getInt(1)+
			          rs.getString(2)+
			          rs.getInt(3)+
			          rs.getString(4)+
			          rs.getInt(5)+
			          rs.getBoolean(6));
		}else {
			System.out.println("No record found");
		}
		
		con.close();
		
		System.out.println();
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		Operation op= new Operation();
//		op.save(41, "Chair", 400, "wooden", 3, true);
		
//		op.delete(22);
		
//		op.update(21, 14999);
		
//		op.fetchAll();
		
//		op.fetchById(32);
		
	}

}
