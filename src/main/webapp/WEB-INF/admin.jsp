
<%@page import="com.guru.ecomspringboothibernate.entity.User"%>
<%
	User user =(User) session.getAttribute("current-user");


	if(user == null){
		session.setAttribute("msg", "<div class='alert alert-warning' role='alert'>You are not logged in! Log in first</div>");
		response.sendRedirect("login");
		return;

	}else {
		if(user.getU_type().equals("normal")){
			session.setAttribute("msg", "<div class='alert alert-warning' role='alert'>You are not admin! you don't have access to admin page.</div>");
			response.sendRedirect("login");
			return;
		}
	}

%>

<%@include file="../component/style.jsp" %>
<%@include file="../component/navbar.jsp" %>
<link rel="stylesheet" href="../css/main.css">

	<div class="container">
		<div class="row mt-4">
		<%-- first Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
						<img style="max-width:100px" class="img-fluid" src="../images/user.png" />
						<h2>4666</h2>
						<h1>User</h1>
					</div>
				</div>
			</div>
			<%-- Second Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
					<img style="max-width:100px" class="img-fluid" src="../images/categories.png" />
						<h2>46546</h2>
						<h1>Categories</h1>
					</div>
				</div>
			</div>
			<%-- Third Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
					<img style="max-width:100px" class="img-fluid" src="../images/packaging.png" />
						<h2>5464</h2>
						<h1>Products</h1>
					</div>
				</div>
			</div>
		</div>

		<%-- Second Row --%>

		<div class="row mt-4">
			<%-- first Col --%>
			<div class="col-md-6">
				<div class="card custome__card">
					<div class="card-body text-center">
					<img style="max-width:100px" class="img-fluid" src="../images/plus.png" />
						<p>Click here to add new Product</p>
						<h1>Add Category</h1>
					</div>
				</div>
			</div>

			<%-- Second Col --%>
			<div class="col-md-6">
				<div class="card custome__card">
					<div class="card-body text-center">
					<img style="max-width:100px" class="img-fluid" src="../images/plus.png" />
						<p>Click here to add new Product</p>
						<h1>Add Product</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
