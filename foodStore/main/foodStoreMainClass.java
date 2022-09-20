package com.Akib.foodStore.main;


import java.util.Scanner;

import com.Akib.foodStore.dao.CartDao;
import com.Akib.foodStore.dao.UserDao;
import com.Akib.foodStore.dao.foodDao;
import com.Akib.foodStore.dao.impl.CartDaoimpl;
import com.Akib.foodStore.dao.impl.FoodDaoimpl;
import com.Akib.foodStore.dao.impl.UserDaoimpl;
import com.Akib.foodStore.pojo.Cart;
import com.Akib.foodStore.pojo.Food;
import com.Akib.foodStore.pojo.User;


public class foodStoreMainClass
{

	public static void main(String[] args) 
	{
		
		foodDao fooddao=new FoodDaoimpl();
		UserDao userdao=new  UserDaoimpl();
	CartDao cartdao=new CartDaoimpl();
	
	
	Cart cart =null;
	Food food=null;
	User user=null;
	
	Scanner sc=new Scanner(System.in);
	int choice;
	String email,pass;
	
		System.out.println("........WELCOME TO FOODSTORE........");
		
		System.out.println("1.login");
		System.out.println("2.registration");
		System.out.println("select your choice?");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("login");
		System.out.println("Email Id:-");
		email=sc.next();
		System.out.println("password:-");
		pass=sc.next();
		user=userdao.login(email,pass);
		if(user!=null)
		{
			if(user.getUserRole().equals("admin"))
			{
				System.out.println("welcome to admin panel");
			}
			else if(user.getUserRole().equals("admin"))
			{
				System.out.println("welcome to Customer panel");
			}else
			{
				System.out.println("inavlid emailid or password");
			}
		}
		}
		
	}

}
