<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
String name=(String)session.getAttribute("name");
String email=(String)session.getAttribute("email");
out.println("hi"+"   " +name+ "your request for loan is in process our executive will contact to" +" " +email);

%>
</body>
</html>