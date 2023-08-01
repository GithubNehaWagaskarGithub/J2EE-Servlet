<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
<h1>KiloMeter is : <%=request.getAttribute("KiloMeter") %></h1>
<h1>Waiting Time is : <%=request.getAttribute("WaitingTime") %></h1>
<h1>KiloMeter is : <%=request.getAttribute("Type") %></h1>
<h1>Calculated Bill is : <%= request.getAttribute("Bill") %></h1>
</form>
</body>
</html>