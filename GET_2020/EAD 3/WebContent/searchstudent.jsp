<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%		
	try {
		int studentclass = Integer.parseInt(request.getParameter("class"));
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement ps;
		if( studentclass == 0 ) {
			 ps = con.prepareStatement("select * from student where firstName=? or lastName=? order by class");
			 ps.setString(1, firstname);
			 ps.setString(2, lastname);
		} else {
			 ps = con.prepareStatement("select * from student where (firstName=? or lastName=?) and class=?");
			 ps.setString(1, firstname);
			 ps.setString(2, lastname);
			 ps.setInt(3, studentclass);
		}
		ResultSet rs = ps.executeQuery();
		int row = rs.getRow();  
		if( row >= 0 ) {
%>
		<h1>Result:</h1>
		<tr>
			<th>
			<form action="searchstudent.jsp?firstName=<%=firstname%>&lastName=<%=lastname%>"  method="post">
				<label>Filter Class</label>
				 <select name="class">
					<%
						for (int i = 1; i <= 12; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>
				</select>
				<input type="submit" value="Filter"/>
			</form>
			</th>
		</tr>
		<table id="displayData">
			<tr>
				<th>Student Name</th>
				<th>Father's Name</th>
				<th>Email</th>
				<th>Class</th>
				<th>Age</th>
				<th></th>
			</tr>
		
		<%
			while (rs.next()) {		
		%>
		
			<tr>
				<td><%=rs.getString("firstName") +" "+ rs.getString("lastName")%></td>
				<td><%=rs.getString("fatherName")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getInt("class")%></td>
				<td><%=rs.getInt("age")%></td>
			</tr>
		</table>
	
<%		
			}
		} else
			out.println("No Result is Found");
		con.close();
	} catch (Exception ex) {
		out.println("Unable to connect to database.");
	}
%>
	
</body>
</html>