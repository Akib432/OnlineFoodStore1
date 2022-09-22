<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<jsp:include page="header.jsp"/>
<div class="container">
	<div class="row">
		<h1>Food Menu</h1>
		
		<div class="row">
		<core:if test="${msg!=null}">
			${msg}
		</core:if>
	</div>
		
	</div>
	<div class="row">
		<table class="table">
			<tr>
				<th>ID</th>
				<th> Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<core:forEach var="food" items="${foodlist}">
				<tr>
					<td>${food.foodid}</td>
					<td>${food.foodName}</td>
					<td>${food.foodType}</td>
					<td>${food.foodprice}</td>
					<td>
					<core:if test="${ user!=null && fn:containsIgnoreCase( user.userRole ,'customer')}">
						<a href="cart?action=add&foodid=${food.foodid}" class="btn btn-outline-primary">Add to Cart</a>
						</core:if>
						<core:if test="${ user!=null &&  fn:containsIgnoreCase (user.userRole ,'admin')}">
						<a href="#" class="btn btn-outline-warning ">Update</a>
						<a href="#" class="btn btn-outline-danger">Delete</a>
						</core:if>
					</td>
				</tr>
			</core:forEach>
		</table>
	</div>
</div>
<jsp:include page="footer.jsp" />
    