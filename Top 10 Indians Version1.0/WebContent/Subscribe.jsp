<%@page import="com.google.mail.SubscribeMail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subscribe</title>
</head>
<body>
	<%
String email=request.getParameter("email");
SubscribeMail.sendMail(email);
response.sendRedirect("index.html?status=mail sent");
%>
</body>
</html>