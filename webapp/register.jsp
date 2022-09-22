<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>

<div class="container">
	<div class="row">
		<h1>Register Here</h1>
	</div>
	<div class="row">
		<form method="post" action="user">
		<input type="hidden" name="action" value="register" >
			<!-- mb margin at bottom  -->
			<div class="mb-3">
				<label for="name" class="form-label">Full Name</label>
				<input type="text" name="userName" id="name" class="form-control"/>
			</div>
			<div class="mb-3">
				<label for="emailId" class="form-label">Email Id</label>
				<input type="text" name="userEmail" id="emailId" class="form-control"/>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" name="userPassword" id="password" 
					class="form-control"/>
			</div>
			<div class="mb-3">
				<input type="hidden" name="userRole" value="customer" id="name" class="form-control"/>
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Address</label>
				<textarea rows="3" cols="25" name="userAddress" id="address" class="form-control"></textarea>
			</div>
			<button type="submit" class="btn btn-outline-success">Register</button>

			
		</form>
	</div>
</div>


<jsp:include page="footer.jsp"/>

    