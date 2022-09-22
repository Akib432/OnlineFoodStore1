<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
  

<jsp:include page="header.jsp"/>
<script>
	$(function(){
		$(".itemQuantity").change(function(){
			let qty = $(this).val()
			
			let itemid=$(this).attr('name')
			let price=$(this).attr('price')

			
			$.ajax({
				url:"cart",
				method:"get",
				data:{
					"action":'updateQty',
					"itemQuantity":qty,
					"itemid":itemid
				},
				success:function(result){
					$('#price'+itemid).text(qty*price)

				}	
			})

		})
	});
</script>



<div class="container">
	<div class="row">
		<h1>Cart Items</h1>
		<div class="row">
		<core:if test="${msg!=null}">
			${msg}
		</core:if>
	</div>
		
	</div>
	<div class="row">
	<core:if test="${cartitems.size() >0}">
		<table class="table">	
			<tr>
				<td>Item Id</td>
				<td>Food Name</td>
				<td>Food Price</td>
				<td>Food Quantity</td>
				<td>Total Price </td>
				<td>Actions</td>
			</tr>
			<core:forEach var="item" items="${cartitems}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.food.foodName}</td>
					<td>${item.food.foodprice}</td>
					<td><input type="number" name="${item.itemId}" price="${item.food.foodprice}"
					 value="${item.itemQuantity}" class="form-control   itemQuantity"  
					 
						 style="width: 60px;" min="1" />
					</td>
					<td id="price${item.itemId }">${item.food.foodprice * item.itemQuantity}</td>
					<td>
						<a href="cart?action=delete&itemId=${item.itemId
						}">Delete</a>
					</td>
				</tr>
			</core:forEach>
		</table>
		<a href="order?action=placeorder" class="btn btn-outline-primary m-2" style="width:150px">Place Order </a>
		
		</core:if>
		<core:if test="${cartitems.size()==0}">
			<p class="alert alert-danger"> Sorry! Your Cart is Empty....</p>
		</core:if>
			
	</div>
</div>
<jsp:include page="footer.jsp" />
   