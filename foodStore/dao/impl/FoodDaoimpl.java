package com.Akib.foodStore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Akib.foodStore.Utility.DBConnection;
import com.Akib.foodStore.dao.foodDao;
import com.Akib.foodStore.pojo.Food;

public class FoodDaoimpl implements foodDao	
{
   Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	String sqlQuery;

	@Override
	public boolean add(Food food ) 
	{
		
		  con = DBConnection.openConnection();
		  
		  sqlQuery="insert into food (foodName,foodPrice,foodType) value(?,?,?)";
		  
		  try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,food.getFoodName());
			ps.setDouble(2,food.getFoodprice());
			ps.setString(3,food.getFoodType());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"rows inserted..");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  finally
		  {
			  DBConnection.closeConnection();
		  }
		 
		 
		return false;
	}

	@Override
	public boolean update(int foodid, Food food) {
		con = DBConnection.openConnection();
		sqlQuery="update food set foodName=?,foodPrice=?,foodType=? where foodId=?";
		 try {
				ps=con.prepareStatement(sqlQuery);
				ps.setString(1,food.getFoodName());
				ps.setDouble(2,food.getFoodprice());
				ps.setString(3,food.getFoodType());
				
				ps.setInt(4,foodid);
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println(i+"rows upadted..");
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  finally
			  {
				  DBConnection.closeConnection();
			  }
		
		return false;
	}

	@Override
	public boolean delete(int foodid) {
		con = DBConnection.openConnection();
		sqlQuery="delete from food where foodId=?";
		 try {
				ps=con.prepareStatement(sqlQuery);
				ps.setInt(1,foodid);
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println(i+"rows Deleted..");
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  finally
			  {
				  DBConnection.closeConnection();
			  }
		
		return false;
	}
	@Override
	public List<Food> all() {
		
		List<Food>foodlist=new ArrayList<>();
		con =DBConnection.openConnection();
		sqlQuery="select * from food";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			rs= ps.executeQuery();
			while(rs.next())
			{
				Food f=new Food(rs.getInt ("foodId"),
						rs.getString("foodName"),
						rs.getDouble("foodprice"),
						rs.getString("foodType"));
				
				foodlist.add(f);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();
		}
		return foodlist;
	}

	@Override
	public Food getById(int foodId) {
		con =DBConnection.openConnection();
		sqlQuery="select *from food where foodId=?";
		try {
			ps= con.prepareStatement(sqlQuery);
			ps.setInt(1,foodId);
			
			rs= ps.executeQuery();
			while(rs.next())
			{
				Food f=new Food(rs.getInt ("foodId"),
						rs.getString("foodName"),
						rs.getDouble("foodprice"),
						rs.getString("foodType"));
				
				return f;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			//DBConnection.closeConnection();
		}
		return null;
	}
 public static void main(String[]args)
 {
     FoodDaoimpl fooddao=new FoodDaoimpl();
	// Food f1= new Food("pizza",301.50,"Nice Food");
	// fooddao.add(f1);
	 
	 //Food f2= new Food("Burger",240.59,"Nice Food");
	// fooddao.add(f2);
	 
	// Food f3= new Food("Sawarma",110.15,"spicy");
	// fooddao.add(f3);
	 
	// Food f4= new Food("Sandwich",150.30,"Nice Food");
	 //fooddao.update(2, f4);
     
    // Food f5= new Food("Sandwich",150.30,"Nice Food");
	// fooddao.add(f5);
     
	// fooddao.delete(2);
     
   //  List<Food>list=fooddao.all();
    // System.out.println(list);
     
     Food f=fooddao.getById(2);
     System.out.println(f);
 }
	
}
