<%@include file="../component/style.jsp" %>
	<%@include file="../component/navbar.jsp" %>


<%@page import="com.guru.ecomspringboothibernate.entity.User"%>
<%
	User user =(User) session.getAttribute("current-user");


	if(user == null){
		session.setAttribute("msg", "<div class='alert alert-warning' role='alert'>You are not logged in! Log in first</div>");
		response.sendRedirect("login");
		return;

	}else {
		if(user.getU_type().equals("admin")){
			session.setAttribute("msg", "<div class='alert alert-warning' role='alert'>You are not normal user!! Do not access this page.</div>");
			response.sendRedirect("login");
			return;
		}
	}

%>

<h1>normal user panel</h1>
