package com.Akib.foodStore.dao;

import com.Akib.foodStore.pojo.User;

public interface UserDao
{
	boolean register(User user);
	
	User login(String userEmail,String userPassword);
	
	void updateprofile(int userId,User user);
	boolean deleteProfile(int userId);

}
