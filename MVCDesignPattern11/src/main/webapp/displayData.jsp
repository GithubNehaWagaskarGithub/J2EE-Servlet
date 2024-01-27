<%@page import="Model.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<table border="1" rules="all">
<tr>
<th>RollNo</th>
<th>Name</th>
<th>Division</th>
<th>Address</th>
<th>City</th>
<th>Marks</th>
<tr>
<%ArrayList<DTO> data=(ArrayList<DTO>) request.getAttribute("ARRAYLISTDATA"); %>
<%for(DTO temp:data) {%>

<tr>
<td><%=temp.getRollNO() %></td>
<td><%=temp.getName() %></td>
<td><%=temp.getDiv() %></td>
<td><%=temp.getAddress() %></td>
<td><%=temp.getCity() %></td>
<td><%=temp.getMarks() %></td>
</tr>
<%}%>


</table>
</body>
</html> 