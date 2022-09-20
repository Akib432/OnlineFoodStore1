package com.Akib.foodStore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Akib.foodStore.Utility.DBConnection;
import com.Akib.foodStore.dao.UserDao;
import com.Akib.foodStore.pojo.User;

public class UserDaoimpl implements UserDao 
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	 String sqlQuery;
	
	@Override
	public boolean register(User user) {
		
		con =DBConnection.openConnection();
		sqlQuery="insert into user(userName,userEmail,userPassword,userAddress,userRole)value(?,?,?,?,?)";
	 
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getUserEmail());
			ps.setString(3,user.getUserPassword());
			ps.setString(4,user.getUserAddress());
			ps.setString(5,user.getUserRole());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"rows inserted..");
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();
		}
		return false;
	}

	@Override
	public User login(String userEmail, String userPassword) {
		con =DBConnection.openConnection();
		sqlQuery="select * from user where userEmail=?  and userPassword=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,userEmail);
			ps.setString(2,userPassword);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				User user=new User(rs.getInt("userId"),
						           rs.getString("userName"),        
						           rs.getString("userEmail"),  
						           rs.getString("userPassword"),
						           rs.getString("userAddress"),
						           rs.getString("userRole"));
				return user;		      
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();
		}
		return null;
	}

	@Override
	public void updateprofile(int userId, User user)
	{
		con =DBConnection.openConnection();
		sqlQuery="update user set userName=?, userEmail=?,userPassword=?,userAddress=? where userId=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getUserEmail());
			ps.setString(3,user.getUserPassword());
			ps.setString(4,user.getUserAddress());
			
			ps.setInt(5,userId);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"row updated..");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();	
		}
		
	}

	@Override
	public boolean deleteProfile(int userId) {
		con =DBConnection.openConnection();
		sqlQuery="delete from user where userId=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,userId);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();	
		}
		
		return false;
	}

	public static void main(String[]args)
	{
		UserDaoimpl userdao=new UserDaoimpl();
		//User u=new User("akib","khan@gmail.com","123","Mumbai","Admin");
		//userdao.register(u);
		
		//User u1=new User("Inzimam","Inzi@gmail.com","1234","Sanpada","Customer");
		//userdao.register(u1);
		
		//User u2=new User("Sadiq","Shaikh@gmail.com","321","Mumbai","Admin");
		//userdao.register(u2);
		
		//User u3=new User("Imran","Imo@gmail.com","124","Mumbai","Customer");
		//userdao.register(u3);
		
	//	User u4=new User("Kashif","Kashif@gmail.com","120","Wadala","Customer");
		//userdao.register(u4);
		
		//User u5=userdao.login("akib@gmail.com","123");
	    // System.out.println(u5);
		
		//User u6=userdao.login("Inzi@gmail.com","1234");
	//	System.out.println(u6);
		
		
	
		
	//	User u8=new User("Danny","Inzi@gmail.com","12345","Mumbai","Customer");
	//	userdao.updateprofile(u6.getUserId(),u8);
		
	//	u6=userdao.login("Inzi@gmail.com","12345");
		//System.out.println(u6);
		
		boolean flag=userdao.deleteProfile(0);
		System.out.println(flag);
		
		flag=userdao.deleteProfile(1);
		System.out.println(flag);
	}
}
