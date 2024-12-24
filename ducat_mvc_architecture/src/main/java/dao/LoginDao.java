package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcon.DbConnection;
import model.User;

public class LoginDao {

	
	
	public User LoginDao(String email,String password) {
	
		User user=null;
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from register where email=? and password = ?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user =new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				
			}
			
		}catch (Exception e) {
			e.getStackTrace();
			
		}
	return user;
	}
}
