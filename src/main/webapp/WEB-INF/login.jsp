<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>miniPixxa - Login</title>
<%@include file="../component/style.jsp"%>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<%@include file="../component/navbar.jsp"%>
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<h3 class="text-center mb-5">Login</h3>
			<div class="card">
				<div class="card-body">
					${msg}
					<form action="login" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input type="email"
								name="email" class="form-control"
								+
            placeholder="example@gmail.com"  />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="password" name="password" class="form-control"
								placeholder="********" >
						</div>
						<div class="container text-center">
							<input type="submit" class="btn btn-primary mt-2">
						</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
