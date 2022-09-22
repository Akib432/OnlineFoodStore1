<%@page import="com.Akib.foodStore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

    
    
   <%
   		User user = (User)session.getAttribute("user");
   %>
    
    
<style>
#main{
min-height:83vh;
}
</style>
<title>Online FoodStore</title>

<link rel="icon" href="images/shop(2).svg" >


<!--  Bootstarp CDN (Conten delivery network)link -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">



<!-- JQuery CDN link -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>



<!--  Bootstarp Icon(Conten delivery network)link -->


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<style>
	#main{
		min-height: 83vh;
	}	
</style>



</head>
<body>
<!-- nav Bar started -->
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"> FoodStore <i class="bi bi-shop"></i></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        <li class="nav-item">
          <li class="nav-item">
          <a class="nav-link" href="food?action=list">Menu</a>
        </li>
        <li>
          <a class="nav-link" href="contactus.jsp">Contact Us</a>
         
        </li>
        <li class="nav-item">
          <a class="nav-link" href="aboutus.jsp">About Us</a>
        </li>
       
      </ul>
     <div class="d-flex">
     
     <!-- replace script if syntax by the JSTL if syntax as follows -->
     
       <core:if test="${user==null}">
       
      		<a href="login.jsp" class="btn btn-outline-primary mx-1"> Login</a>
      		<a href="register.jsp" class="btn btn-outline-primary mx-1"> Register</a>
      	</core:if>
      	
     	<%if(user != null){ %>
     		<!-- URL Rewriting   -->
      		<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
				   <%=user.getUserName()%>
				  </button>
				  <ul class="dropdown-menu">
				  <%if(user.getUserRole().equalsIgnoreCase("admin")){ %>
				    <li><a class="dropdown-item" href="admin.jsp">Add Admin</a></li>	    
				    <li><a class="dropdown-item" href="#">Add Food</a></li>
				   <%} %>
				   <%if(user.getUserRole().equalsIgnoreCase("customer")){ %>
				     <li><a class="dropdown-item" href="cart?action=view">View Cart [${cartitems.size()}]
				     </a></li>
				    <li><a class="dropdown-item" href="myorder?action=view">My Orders</a></li>
				   <%} %>
				    <li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
				    <li><a class="dropdown-item" href="confirmdeleteprofile.jsp">Delete Profile</a></li>
				    <li><a class="dropdown-item" href="user?action=logout">Logout</a></li>
				  </ul>
			</div>
      		
      	<%} %>

      	
      </div>

    </div>
  </div>
</nav>

<!-- Nav Bar ended -->


<!-- main Section started -->
<div id="main">








