
<%@page import="com.Akib.foodStore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User user =  (User)session.getAttribute("user");
%>

<jsp:include page="header.jsp"/>

<div class="container mb-2">
	<div class="row">
		<h1>Update Profile Here</h1>
	</div>
	<div class="row">
		<form method="post" action="user">
			<input type="hidden" name="action" value="updateprofile">
			<div class="mb-3">
				<label for="id" class="form-label">User Id</label>
				<input type="text" name="userId" id="id" class="form-control"
				value="<%=user.getUserId()%>"/>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">Full Name</label>
				<input type="text" name="userName" id="name" class="form-control">
				</div>
                   <div class="mb-3">
				<label for="emailId" class="form-label">Email Id</label>
				<input type="text" name="userEmail" id="emailId" class="form-control"
				value="<%=user.getUserEmail()%>"/>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" name="userPassword" id="password" 
					class="form-control" value="<%=user.getUserPassword()%>"/>
			</div>
			<div class="mb-3">
				<label for="emailId" class="form-label">User Role</label>
				
				<input type="text" name="userRole" value="<%=user.getUserRole()%>" id="name" 
				class="form-control" readonly/>
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Address</label>
				<textarea rows="3" cols="25" name="userAddress" id="address" class="form-control"><%=user.getUserAddress() %></textarea>
			</div>
			<button type="submit" class="btn btn-outline-success">Update</button>
		</form>
	</div>
</div>


<jsp:include page="footer.jsp"/>
