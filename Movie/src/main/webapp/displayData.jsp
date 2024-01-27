<%-- <%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Object res=request.getAttribute("ARRAYLISTDATA"); %>
<%ArrayList<StudentClass> data=(ArrayList<StudentClass>) res; %>
<table border="1" rules="all">
<tr>
<th>Student ID</th>
<th>Student Name</th>
<th>Student Division</th>
<th>Student Address</th>
<th>Student City</th>
<th>Student Marks</th>
</tr>
<% for(StudentClass temp:data){ %>
<tr>
<td><%=temp.getSId %></td>
<td><%=temp.getSName %></td>
<td><%=temp.getSDiv %></td>
<td><%=temp.getSAdd %></td>
<td><%=temp.getSCity %></td>
<td><%=temp.getSPer %></td>
</tr>
<%} %>
</table>
</body>
</html> --%>