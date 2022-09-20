package com.Akib.foodStore.dao;

import java.util.List;

import com.Akib.foodStore.pojo.Food;

public interface foodDao {
	boolean add(Food food);
	
	
	boolean update(int foodid,Food food);
	boolean delete(int foodid);
	
	List<Food>all();
	
	Food getById(int foodId);
}
