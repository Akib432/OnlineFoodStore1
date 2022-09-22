<%@page import="com.Akib.foodStore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% 
	String msg = (String)session.getAttribute("msg");
	User user = (User)session.getAttribute("user");
	session.removeAttribute("msg");
%>
    
    
<jsp:include page="header.jsp"/>
    
  <p>
   		<%if(msg!=null) {%>
			<%=msg%>
		<%}%>
	</p>
	<% if(user!=null){ %>
		<h1>Welcome <%=user.getUserName()%></h1>
   <%} %>
  
   
    <jsp:include page="footer.jsp"/>