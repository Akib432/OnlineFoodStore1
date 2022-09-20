package com.Akib.foodStore.dao;

import java.util.List;

import com.Akib.foodStore.pojo.Cart;

public interface CartDao
{
boolean addToCart(Cart cart);
boolean removeItem(int itemId);
boolean clearCart(int userId);
List<Cart>viewCart(int userId);
boolean updateItemQty(int itemId,int itemQuantity);

	
}
