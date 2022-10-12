<%@page import="com.guru.ecomspringboothibernate.entity.Category"%>
<%@page import="com.guru.ecomspringboothibernate.entity.Product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>miniPixxa</title>
    <%@include file="../component/style.jsp" %>
    <link rel="stylesheet" href="../css/main.css">
  </head>
  <body>
    <%@include file="../component/navbar.jsp" %>
    <div class="container">
    <div class="row mt-4">
        <div class="col-md-3">

            <ul class="list-group sticky-top">
            <li class="list-group-item active">Category</li>
            <li class="list-group-item"><a href="#">All Products</a></li>
            <%
             List<Category> catList = (List<Category>) request.getAttribute("categoryList");
             for(Category c : catList){
              %>
                 <li class="list-group-item">
                    <a href="#">
                    <%= c.getC_name()%>
                    </a>
                  </li>
                <%
             }
                %>
          </ul>
        </div>

        <div class="col-md-9">
          <div class="card_custome">
              <%
             List<Product> productList = (List<Product>) request.getAttribute("productsList");
             for(Product p : productList){
              %>
              <div class="card" style="width: 16rem;">
                <img class="card-img-top img-fluid" style="max-height:280px; max-width:100%;" src="./images/products/<%= p.getP_photo()%>" alt="<%= p.getP_name() %>">
                <div class="card-body">
                  <h6 class="card-title"><%= p.getP_name() %></h6>
                </div>
                <div class="card-footer d-flex justify-content-between align-items-center">
                  <small class="text-muted">Rs. <%= p.getP_price()%></small>
                  <a class="btn btn-primary btn-sm text-white">Add to Cart</a>
                </div>
              </div>
          <%
             }
        %>
          </div>
        </div>
    </div>
    </div>
  </body>
</html>
