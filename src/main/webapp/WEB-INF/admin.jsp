<%@page import="java.util.ArrayList"%>
<%@page import="com.guru.ecomspringboothibernate.Dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.guru.ecomspringboothibernate.entity.User"%>
<%@page import="com.guru.ecomspringboothibernate.entity.Category"%>
<%
User user = (User) session.getAttribute("current-user");


if (user == null) {
	session.setAttribute("msg",
	"<div class='alert alert-warning' role='alert'>You are not logged in! Log in first</div>");
	response.sendRedirect("login");
	return;

} else {
	if (user.getU_type().equals("normal")) {
		session.setAttribute("msg",
		"<div class='alert alert-warning' role='alert'>You are not admin! you don't have access to admin page.</div>");
		response.sendRedirect("login");
		return;
	}
}
%>

<%

CategoryDao cd = new CategoryDao();
ArrayList<Category> list = (ArrayList<Category>) cd.getCategories();

if (list != null) {
	out.println(list.isEmpty());
}
%>


<html>
<head>
<title></title>
<%@include file="../component/style.jsp"%>
<%@include file="../component/navbar.jsp"%>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<div style="max-width: 500px;" class="container mt-4">
		${cate_message}</div>

	<div class="container">
		<div class="row mt-4">
			<%-- first Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
						<img style="max-width: 100px" class="img-fluid"
							src="../images/user.png" />
						<h2>4666</h2>
						<h1>User</h1>
					</div>
				</div>
			</div>
			<%-- Second Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
						<img style="max-width: 100px" class="img-fluid"
							src="../images/categories.png" />
						<h2>46546</h2>
						<h1>Categories</h1>
					</div>
				</div>
			</div>
			<%-- Third Col --%>
			<div class="col-md-4">
				<div class="card custome__card">
					<div class="card-body text-center">
						<img style="max-width: 100px" class="img-fluid"
							src="../images/packaging.png" />
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
				<div class="card custome__card" data-toggle="modal"
					data-target="#addCategoryModal">
					<div class="card-body text-center">
						<img style="max-width: 100px" class="img-fluid"
							src="../images/plus.png" />
						<%-- <p>Click here to add new Product</p> --%>
						<h1>Add Category</h1>
					</div>
				</div>
			</div>

			<%-- Second Col --%>
			<div class="col-md-6">
				<div class="card custome__card" data-toggle="modal"
					data-target="#addProductModal">
					<div class="card-body text-center">
						<img style="max-width: 100px" class="img-fluid"
							src="../images/plus.png" />
						<%-- <p>Click here to add new Product</p> --%>
						<h1>Add Product</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Add Category Modal -->
	<div class="modal fade" id="addCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add New
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addNewCategory" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="categoryTitle"
								placeholder="Category Name" required />
						</div>
						<div class="form-group">
							<textarea class="form-control" id="categoryDesc"
								placeholder="Category Description" name="categoryDesc" rows="3"
								required></textarea>
						</div>
						<button class="btn btn-primary">Add</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Add Product Modal -->

	<div class="modal fade" id="addProductModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addNewProduct" , method="POST">
						<div class="form-group">
							<input type="text" class="form-control" name="productTitle"
								placeholder="Product Name" required />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="productQty"
								placeholder="Quantity" required />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="productPrice"
								placeholder="Price" required />
						</div>


						<div class="form-group"></div>
						<div class="form-group">
							<textarea class="form-control" id="productDesc"
								placeholder="Description" rows="3" name="productDesc" required></textarea>
						</div>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="productImage"
								name="productImage"> <label class="custom-file-label"
								for="inputGroupFile01">Upload Image</label>
						</div>
						<button class="btn btn-primary">Add</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>