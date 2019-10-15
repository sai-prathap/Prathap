<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtusa.cabmodel.Cab"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cabs</title>
</head>
<body>
<table>
<tr>
	<th>  CabNumber</th>
	<th>Driver Name </th>
	<th>Driver Number </th>
	<th> Status</th>
	</tr>
<%
ArrayList<Cab> emp = (ArrayList<Cab>) request.getAttribute("cab");
for(int i = 0;i<emp.size();i++)
{
	%>
	<tr>
	<td><% out.println(emp.get(i).getCab_number()); %></td>
	<td><% out.println(emp.get(i).getCab_driver_name()); %></td>
	<td><% out.println(emp.get(i).getDriver_phno()); %></td>
	<td><% out.println(emp.get(i).getStatus()); %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>