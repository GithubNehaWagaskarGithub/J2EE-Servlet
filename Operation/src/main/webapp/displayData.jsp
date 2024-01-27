<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%Object res=request.getAttribute("ARRAYLISTDATA"); %>
<%ArrayList<DTO> data=(ArrayList<DTO>) res; %>
<table border="1" rules="all">
<tr>
<th>Student ID</th>
<th>Student SAL</th>

</tr>
<% for(DTO temp:data){ %>
<tr>
<td><%=temp.getId %></td>
<td><%=temp.getSal %></td>

</tr>
<%} %>
</table>
</body>
</html> --%>