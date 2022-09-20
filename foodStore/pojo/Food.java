package com.Akib.foodStore.pojo;

public class Food {
private int foodid;
private String foodName;
private double foodprice;
private String foodType;

	



public Food(int foodid, String foodName, double foodprice, String foodType) {
	super();
	this.foodid = foodid;
	this.foodName = foodName;
	this.foodprice = foodprice;
	this.foodType = foodType;
}
public Food(String foodName, double foodprice, String foodType) {
	super();
	this.foodName = foodName;
	this.foodprice = foodprice;
	this.foodType = foodType;
}
public Food() {
	super();
	// TODO Auto-generated constructor stub
}
public int getFoodid() {
	return foodid;
}
public void setFoodid(int foodid) {
	this.foodid = foodid;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public double getFoodprice() {
	return foodprice;
}
public void setFoodprice(double foodprice) {
	this.foodprice = foodprice;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
@Override
public String toString() {
	return "Food [foodid=" + foodid + ", foodName=" + foodName + ", foodprice=" + foodprice + ", foodType=" + foodType
			+ "]";
}




}
