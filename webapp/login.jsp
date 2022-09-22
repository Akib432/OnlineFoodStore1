
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String msg = (String)session.getAttribute("msg");
	session.removeAttribute("msg");
%>

<jsp:include page="header.jsp"/>

<div class="container">
	<div class="row">
		<h1>Login Here</h1>
	</div>
	<div class="row">
		<%if(msg!=null) {%>
			<%=msg%>
		<%}%>
	</div>
	<div class="row">
		<form method="post" action="user">
			<input type="hidden" name="action" value="login">
			<!-- mb margin at bottom  -->
			<div class="mb-3">
				<label for="emailId" class="form-label">Email Id</label>
				<input type="text" name="userEmail" id="emailId" class="form-control"/>
			</div>
			<div class="mb-3">
			<label for="password" class="form-label">Password</label>
				<input type="password" name="userPassword" id="password" 
					class="form-control"/>
			</div>
			<button type="submit" class="btn btn-outline-success">Login</button>
		</form>
	</div>
</div>


<jsp:include page="footer.jsp"/>

			
			
 