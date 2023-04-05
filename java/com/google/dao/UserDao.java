package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.bean.UserBean;
import com.google.util.DbConnection;

public class UserDao {
	public void addUser(UserBean user){
		Connection cn = null;
		try {
			cn = DbConnection.appConnection();
			PreparedStatement pst = cn.prepareStatement("insert into users(firstName, email, password) values(?, ?, ?)");
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			int inserted = pst.executeUpdate();
			if (inserted>0) {
				System.out.println("Data inserted successfully");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Data not inserted");
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteUser(Integer userId) {
		Connection cn = null;
		try {
			cn = DbConnection.appConnection();
			PreparedStatement pst = cn.prepareStatement("delete from users where id=?");
			pst.setInt(1, userId);
			int deleted = pst.executeUpdate();
			if(deleted>0) {
				System.out.println("Data deleted successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("data not deleted");
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserBean authenticate(String email, String password){
		UserBean user = null;
		
		Connection cn = null;
		try {
			cn = DbConnection.appConnection();
			user = new UserBean();
			PreparedStatement pst = cn.prepareStatement("select * from users where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				user.setUserId(rs.getInt("id")); 
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password")); 
			}
		} catch (SQLException e) {
			System.out.println("wrong data entered");
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void editUser(UserBean user) {
		Connection cn = null;
//		UserBean user = new UserBean();
		try {
			cn = DbConnection.appConnection();
			PreparedStatement pst = cn.prepareStatement("update users set firstName=?, email=?, password=? where id=?");
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setInt(4, user.getUserId());
			int updated = pst.executeUpdate();
			if(updated>0) {
				System.out.println("data updated successfully");
			}
		} catch (SQLException e) {
			System.out.println("data not updated");
			System.out.println(user.getFirstName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserBean getUserById(Integer userId){
		UserBean user = null;
		
		Connection cn = null;
		try {
			cn = DbConnection.appConnection();
			user = new UserBean();
			PreparedStatement pst = cn.prepareStatement("select * from users where id=?");
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				user.setUserId(rs.getInt("id")); 
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password")); 
			}
		} catch (SQLException e) {
			System.out.println("wrong data entered");
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public ArrayList<UserBean> getAllUsers(){
		Connection cn = null;
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			cn = DbConnection.appConnection();
			PreparedStatement pst = cn.prepareStatement("select * from users");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("id")); 
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password")); 
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Couldn't fetch data");
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
		
	}
	public ArrayList<UserBean> searchData(String searchName){
		Connection cn = null;
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			cn = DbConnection.appConnection();
			PreparedStatement pst = cn.prepareStatement("select * from users where firstName like ?");
			pst.setString(1, searchName+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("id")); 
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password")); 
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Couldn't fetch data");
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		UserBean user = new UserBean();
		ud.editUser(user);
	}
}
