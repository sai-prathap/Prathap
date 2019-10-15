<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
   <%@page import="java.util.ArrayList"%>
   <%@page import="com.virtusa.userbooking.model.UserBooking" %>
   <%@page import="com.virtusa.userbookingdao.UserBookingDaoImp" %>
   <%@page import="com.virtusa.cabmodel.Cab" %>
   <%@page import="com.virtusa.cabdao.CabDaoimpl" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String status = request.getParameter("status");
		if(status == null) {
	%>
	<form action="AllocateServlet" method="Post">
	
	
	<table>
		<tr>
			<th>Emp Id</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Time</th>
			<th>Status</th>
			<th> cab no</th>
		</tr>
		<%
			ArrayList<UserBooking> stat = (ArrayList<UserBooking>) request.getAttribute("status");
				for (int i = 0; i < stat.size(); i++) {
		%>
		<tr>
			<td>
				<%
					out.println(stat.get(i).getEmp_id());
				%>
			</td>
			<td>
				<%
					out.println(stat.get(i).getSource());
				%>
			</td>
			<td>
				<%
					out.println(stat.get(i).getDestination());
				%>
			</td>
			<td>
				<%
					out.println(stat.get(i).getTime());
				%>
			</td>
			<td>
				<select name="status">
				<option>select</option>
				<option value="accept">Accept</option>
				<option value="reject">Reject</option>
				</select>
			</td>
			<td>
				<select name="cabid">
				<option>select</option>
				<% 
				CabDaoimpl cab = new CabDaoimpl();
				List<String> cab_no =cab.findById(0);
				for(int j=0;j<cab_no.size();j++)
				{
				%>
				<option value=<% out.println(cab_no.get(j)); %>><% out.println(cab_no.get(j)); %></option>
				<%
				}
				%>
				</select>
			</td>
			<td>
			<input type="hidden" name="empid" value="<% out.println(stat.get(i).getEmp_id()); %>">
			<input type="hidden" name="source" value="<% out.println(stat.get(i).getSource()); %>">
			<input type="hidden" name="destination" value="<% out.println(stat.get(i).getDestination()); %>">
			<input type="hidden" name="time" value="<% out.println(stat.get(i).getTime()); %>">
			<input type="submit" name="sub" value = "submit">
			</td>
		</tr>
		<%
}
		}	
%>
	</table>
	</form>
</body>
</html>