package com.Akib.foodStore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Akib.foodStore.dao.impl.CartDaoimpl;
import com.Akib.foodStore.dao.impl.OrderDaoimpl;
import com.Akib.foodStore.pojo.User;


@WebServlet("/order")
public class OrderServlet extends HttpServlet

{
	HttpSession session;
	String action;
	
	User user = null;
	OrderDaoimpl orderDao = new  OrderDaoimpl();
  CartDaoimpl cartDao=new CartDaoimpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			session = req.getSession();
			action = req.getParameter("action");
			user =(User) session.getAttribute("user");
			
			if(action!=null && action.equalsIgnoreCase("placeorder"))
			{	
				orderDao.placeOrder(user.getUserId());
				cartDao.clearCart(user.getUserId());
				resp.sendRedirect("Order.jsp");

			}

			
			
			
		}

}
