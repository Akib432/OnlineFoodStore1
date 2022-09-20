package com.Akib.foodStore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Akib.foodStore.dao.impl.UserDaoimpl;
import com.Akib.foodStore.pojo.User;




@WebServlet("/user")
public class UserController  extends HttpServlet{



String userName, userAddress,userRole ;
boolean flag;


   int userId;
	String action;
	String userEmail,userPassword;
	
	User user = null;
	UserDaoimpl userDao = new UserDaoimpl();
	
	HttpSession session = null;

	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	action= req.getParameter("action");
	session = req.getSession(); // it use store user data if login successfully.
	
	if(action!=null && action.equalsIgnoreCase("login"))
	{
		userEmail= req.getParameter("userEmail");
		userPassword= req.getParameter("userPassword");
		
		user = userDao.login(userEmail, userPassword);
		
		if(user!=null)
		{
			session.setAttribute("user", user);
			session.setAttribute("msg", "Login successfully");
			
			resp.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("msg", "Invalid Email or Password.");
			resp.sendRedirect("login.jsp");
		}
		
	}
	else if(action!=null && action.equalsIgnoreCase("register"))
	{
		userName = req.getParameter("userName");
		userEmail = req.getParameter("userEmail");
		userPassword = req.getParameter("userPassword");
		userRole= req.getParameter("userRole");
		userAddress= req.getParameter("userAddress");
		
		user = new User(userName, userEmail, userPassword, userAddress, userRole);
		
		flag = userDao.register(user);
		
		if(flag)
		{
			if(userRole.equalsIgnoreCase("admin")){
				session.setAttribute("msg", "New Admin Registration is Successfull.");
				resp.sendRedirect("admin.jsp");
			
			}else {
				session.setAttribute("msg", "Registration is Successfull.");
				resp.sendRedirect("login.jsp");
			}
		}else {
			
			session.setAttribute("msg", "Registration is Unsuccessfull. Try Again");
			resp.sendRedirect("register.jsp");

	}

	}	
else if(action!=null && action.equalsIgnoreCase("updateprofile"))
{
	userId = Integer.parseInt(req.getParameter("userId"));
	userName = req.getParameter("userName");
	userEmail = req.getParameter("userEmail");
	userPassword = req.getParameter("userPassword");
	userRole= req.getParameter("userRole");
	userAddress= req.getParameter("userAddress");
	
	user = new User(userId, userName, userEmail, userPassword, userAddress, userRole);
	
	userDao.updateprofile(userId, user);
	session.setAttribute("user", user);
	session.setAttribute("msg", "Profile is Updated..");
	resp.sendRedirect("profile.jsp");
	
}
else if(action!=null && action.equalsIgnoreCase("deleteprofile"))
{
	userId = Integer.parseInt(req.getParameter("userId"));
	flag = userDao.deleteProfile(userId);
	if(flag) 
	{
		session.removeAttribute("user");
		session.setAttribute("msg", "Profile is Deleted..");
		resp.sendRedirect("index.jsp");
	}else {

		session.setAttribute("msg", "Profile is NOT Deleted..");
		resp.sendRedirect("profile.jsp");
	
}
}
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	action= req.getParameter("action");
	session = req.getSession(); // it use store user data if login successfully.

	if(action!=null && action.equalsIgnoreCase("logout"))
	{
		session.invalidate();
		session = req.getSession();// after invaliding old session create new session.
		session.setAttribute("msg", "Logout Succssfully...");
		resp.sendRedirect("login.jsp");
		
	}
}

}

