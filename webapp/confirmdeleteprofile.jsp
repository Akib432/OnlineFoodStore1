<%@page import="com.Akib.foodStore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	User user =  (User)session.getAttribute("user");
%>
<jsp:include page="header.jsp"/>

<div class="container">
	<form method="post" action="user">
		<input type="hidden" name="action" value="deleteprofile">
		<input type="hidden" name="userId" value="<%=user.getUserId()%>">
		<h3>Hii <%=user.getUserName()%></h3>
		<p> Are you Sure you want to delete your Profile </p>
		<input type="submit" class="btn btn-outline-danger" value="Yes"/>
		
		<a type="submit" class="btn btn-outline-primary"
		href="profile.jsp">Back</a>
</form>
</div>

<jsp:include page="footer.jsp" />

