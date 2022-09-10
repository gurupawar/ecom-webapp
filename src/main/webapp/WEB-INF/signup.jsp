<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign Up</title>
    <%@include file="../component/style.jsp" %>
    <link rel="stylesheet" href="../css/main.css">
  </head>
  <body>
    <%@include file="../component/navbar.jsp" %>
    <div class="row mt-5">
      <div class="col-md-4 offset-md-4">
        <h3 class="text-center mb-5">Sign up here</h3>
        <%@include file="../component/message.jsp" %>
        <div class="card">
          <div class="card-body">
        <form action="signup" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">First Name</label>
            <input
            type="text"
            name="firstName"
            class="form-control"
            +
            placeholder="Jonh Duo"
            />
          </div>

          <div class="form-group">
            <label for="exampleInputEmail1">Last Name</label>
            <input
            type="text"
            name="lastName"
            class="form-control"
            placeholder="Jonh Duo"
            />
          </div>          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input
            type="email"
            name="email"
            class="form-control"
            aria-describedby="emailHelp"
            placeholder="Enter email"
            />
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Password</label>
            <input
            type="password"
            name="password"
            class="form-control"
            placeholder="*******"
            />
          </div>
          <button class="btn btn-primary">Register</button>
        </div>
      </form>
    </div>
  </div>
    </div>
  </body>
</html>
