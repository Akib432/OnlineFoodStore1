package com.Akib.foodStore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Akib.foodStore.dao.impl.CartDaoimpl;
import com.Akib.foodStore.pojo.Cart;
import com.Akib.foodStore.pojo.User;


@WebServlet("/cart")
public class CartController extends HttpServlet
{
	String action;
	
	int itemId,itemQuantity;

	
	int foodId;
	boolean flag;

	
	Cart cart;
	User user = null;
	CartDaoimpl cartDao = new CartDaoimpl();
	List<Cart> cartitems = new ArrayList<Cart>(); 
	
	HttpSession session = null;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		session = req.getSession();
		action = req.getParameter("action");
		user = (User)session.getAttribute("user");
	if(action!=null && action.equalsIgnoreCase("view"))
		{
			cartitems = cartDao.viewCart(user.getUserId());
			session.setAttribute("cartitems", cartitems);
			resp.sendRedirect("viewcart.jsp");
		}
	else if(action!=null && action.equalsIgnoreCase("add"))
	{
		
		foodId = Integer.parseInt(req.getParameter("foodid"));
		cart = new Cart(foodId, 1,user.getUserId());
		flag = cartDao.addToCart(cart);
		if(flag)
		{
			session.setAttribute("msg","Item is Added into Cart");
			cartitems = cartDao.viewCart(user.getUserId());
			session.setAttribute("cartitems", cartitems);
			resp.sendRedirect("viewcart.jsp");
		}else {
			session.setAttribute("msg","Item is not  Added into Cart try agin");
			resp.sendRedirect("foodlist.jsp");
			
		}

	}
	else if(action!=null && action.equalsIgnoreCase("updateQty")) {
		itemId= Integer.parseInt(req.getParameter("itemid"));
		itemQuantity= Integer.parseInt(req.getParameter("itemQuantity"));
		System.out.println(itemId);
		System.out.println(itemQuantity);
		cartDao.updateItemQty(itemId,itemQuantity);
	}
	else if(action!=null && action.equalsIgnoreCase("delete")) {
		
		itemId= Integer.parseInt(req.getParameter("itemid"));
		cartDao.removeItem(itemId);
		session.setAttribute("msg","Item is Remove From Cart");
		cartitems = cartDao.viewCart(user.getUserId());
		session.setAttribute("cartitems", cartitems);
		resp.sendRedirect("viewcart.jsp");

		
	}

		
	}
}

