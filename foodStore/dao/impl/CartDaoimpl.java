package com.Akib.foodStore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Akib.foodStore.Utility.DBConnection;
import com.Akib.foodStore.dao.CartDao;
import com.Akib.foodStore.pojo.Cart;
import com.Akib.foodStore.pojo.Food;
import com.Akib.foodStore.pojo.User;


public class CartDaoimpl implements CartDao
{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sqlQuery;
	
	FoodDaoimpl fooddao=new FoodDaoimpl();

	@Override
	public boolean addToCart(Cart cart) 
	{
		con=DBConnection.openConnection();
		sqlQuery="insert into cart(foodId,itemQuantity,userId) values(?,?,?)";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setInt(1,cart.getFoodId());
			ps.setInt(2,cart.getItemQuantity());
			ps.setInt(3,cart.getUserId());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"inserted..");
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
	public boolean removeItem(int itemId) {
		con=DBConnection.openConnection();
		sqlQuery="delete *from cart where itemId=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,itemId);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"rows deleted");
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
	public boolean clearCart(int userId) {
		con=DBConnection.openConnection();
		sqlQuery="delete *from cart where userId=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
          ps.setInt(1,userId);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"rows deleted");
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
	public List<Cart> viewCart(int userId) {
		List<Cart>cartlist=new ArrayList<Cart>();
		
		con=DBConnection.openConnection();
		sqlQuery="select *from cart where userId=?";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Food food=fooddao.getById(rs.getInt("foodId"));
				Cart cart=new Cart();
				cart.setItemId(rs.getInt("itemId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setFood(food);
				cart.setItemQuantity(rs.getInt("itemQuantity"));
				
				cart.setUserId(rs.getInt("UserId"));
				
				cartlist.add(cart);
				
			}
			
			return cartlist;
		} catch (SQLException e) {	
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();
		}
		return null;
	}

	public static void main(String[]args)
	{
		UserDaoimpl  userdao= new UserDaoimpl();
		CartDaoimpl cartdao=new CartDaoimpl();
		User u=userdao.login("Shaikh@gmail.com","321");
		/*Cart c=new Cart(3,4,u.getUserId());
		
		CartDaoimpl cartdao=new CartDaoimpl();
		cartdao.addToCart(c);
		*/
		
		Cart c=new Cart(3,4,u.getUserId());
		List<Cart>cartlist=cartdao.viewCart(u.getUserId());
		for(Cart item:cartlist)
		{
			System.out.println(item);
		}
		
	}

	@Override
	public boolean updateItemQty(int itemId, int itemQuantity)
	{
		con = DBConnection.openConnection();
		sqlQuery="update cart set itemQuantity=?  where itemId=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, itemQuantity);
			ps.setInt(2, itemId);
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println(i+" Rows updated..");
				return true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection();
		}

		return false;
	}
	}


