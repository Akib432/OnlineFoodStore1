package com.Akib.foodStore.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Akib.foodStore.Utility.DBConnection;
import com.Akib.foodStore.dao.OrderDao;

public class OrderDaoimpl implements OrderDao

{
	Connection con;
	PreparedStatement ps, ps1;
	ResultSet rs ;
	
	String sqlQuery1, sqlQuery2;
	double totalprice;
	String orderDate;
	


	@Override
	public void placeOrder(int userId) {
		
		try 
		{
			con = DBConnection.openConnection();
			
			sqlQuery1 = "select sum(f.foodprice * c.itemQuantity) from food f inner join cart c on(f.foodId=c.foodId) where userId=?";
			ps = con.prepareStatement(sqlQuery1);
			ps.setInt(1,userId);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				totalprice = rs.getDouble(1);
				orderDate = new Date().toString();
				System.out.println("Total Price"+totalprice);
				System.out.println("Order Date"+orderDate);
				
				sqlQuery2 = "insert into orders (totalPrice,orderDate,userId) values (?,?,?)";
				
				ps1 = con.prepareStatement(sqlQuery2);
				ps1.setDouble(1, totalprice);
				ps1.setString(2, orderDate);
				ps1.setInt(3, userId);
				
				int i = ps1.executeUpdate();
				if(i>0)
				{
					System.out.println("Order Has been Placed..");
				}
				else {
					System.out.println("Not Placed.");
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection();
		}


		
	}

	

}
