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

import com.Akib.foodStore.dao.impl.FoodDaoimpl;
import com.Akib.foodStore.pojo.Food;
@WebServlet("/food")
public class FoodController extends HttpServlet

{
	
String action;
	
	int foodId;
	String foodName,foodType;
	double foodPrice;
	boolean flag;
	List<Food> foodlist = new ArrayList<Food>();
	
	Food food=null;
	FoodDaoimpl foodDao = new FoodDaoimpl();
	
	HttpSession session = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		action = req.getParameter("action");
		session = req.getSession();
		
		if(action!=null && action.equals("list")) {
			foodlist = foodDao.all();
			session.setAttribute("foodlist", foodlist);
			resp.sendRedirect("foodlist.jsp");
			
		}	
	}

			

	}
	


