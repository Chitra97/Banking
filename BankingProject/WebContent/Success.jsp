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
out.print("Welcome"+" " + name +" "+ "to bank");
%>
<br>
<a href="CheckBalance">click here to get the balance</a>
</br>
<br>
<a href="change.jsp">Click here to change Password</a>
</br>
<br>
<a href="transferamt.jsp">Click here to transfer amount</a>
</br>
<br>
<a href="GetStatement">click here to get Statement</a>
</br>

<br>
<a href="applyLoan.jsp">click here to apply loan</a>
</br>


<br>
<a href="logout.jsp">click here logout</a>
</br>

</body>
</html>