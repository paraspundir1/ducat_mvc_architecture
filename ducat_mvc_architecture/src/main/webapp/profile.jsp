<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> <% 
User user =(User)session.getAttribute("session_user");
out.println(user.getName());

out.println(user.getCity());

out.println(user.getEmail());
%></h1>
</body>
</html>