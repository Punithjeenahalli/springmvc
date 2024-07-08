<%@page import="java.util.List"%>
<%@page import="springmvc3.DoctorDto.DoctorDto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<DoctorDto> list=(List<DoctorDto>)request.getAttribute("object");%>
<table border="" style="border: 5px solid; color: purple; width: 100vh; height: 50vh; font-family: fantasy; font-size: x-large;">
<tr>
<th>did</th>
<th>dname</th>
<th>grade</th>
<th>update</th>
</tr>
<%for(DoctorDto a : list){ %>
<tr>
<td><%= a.getDid() %></td>
<td><%=a.getDname() %>
<td><%=a.getGrade() %>
<td><a href="update.jsp?did=<%= a.getDid()%>&&dname=<%=a.getDname()%>&&grade=<%=a.getGrade()%>">edit</a></td>
<%} %>
</tr>
</table>
</body>
</html>