<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Success</h1>
<%
session=request.getSession();
String name=(String)session.getAttribute("name");
int balance=(int)session.getAttribute("balance");
out.print("Welcome"+" " + name +" "+ "to bank");
out.print("balance is" +balance);
%>
</body>
</html>