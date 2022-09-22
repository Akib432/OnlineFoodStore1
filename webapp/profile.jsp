
<%@page import="com.Akib.foodStore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User user =  (User)session.getAttribute("user");
%>
<% 
	String msg = (String)session.getAttribute("msg");
	session.removeAttribute("msg");
%>


<jsp:include page="header.jsp"/>
	<div class="container">
	<div class="row">
		<%if(msg!=null) {%>
			<%=msg%>
		<%}%>
	</div>
	
		
		<table class="table table-hover" align="center" style="width: 80%">
			<tr>
				<th colspan="2">
					<h1 style="text-align: center;">My Profile</h1>
				</th>
			</tr>
			<tr>
				<td>Full Name </td>
				<th><%=user.getUserName()%></th>
			</tr>
			<tr>
				<td>Role</td>
				<th><%=user.getUserRole()%></th>
			</tr>
			<tr>
				<td>Email Id </td>
				<th><%=user.getUserEmail()%></th>
			</tr>
			<tr>
				<td>Password </td>
				<th><%=user.getUserPassword()%></th>
			</tr>
			<tr>
				<td>Address </td>
				<th><%=user.getUserAddress()%></th>
			</tr>
			<tr>
				<th colspan="2">
					<a href="updateprofile.jsp"
					 class="btn btn-outline-success">Edit</a>
				</th>
			</tr>
		</table>
		
	
	</div>

<jsp:include page="footer.jsp"/>
