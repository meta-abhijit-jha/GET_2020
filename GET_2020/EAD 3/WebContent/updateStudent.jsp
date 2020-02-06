<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="cssfile.css" />
</head>
<body>
	<form id="registerformid" action="update.jsp" method="get">

		<%
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				out.print(id);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
				PreparedStatement ps = con.prepareStatement("select * from student where studentId=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				rs.next();
		%>

		<fieldset>
			<h1>Student Detail Form</h1>
			<input name="id" value="<%=id%> " hidden> <input
				id="firstname" type="text" name="firstname"
				value="<%=rs.getString("firstname")%>"><br>
			<br> <input id="lastname" type="text" name="lastname"
				value="<%=rs.getString("lastname")%>"><br>
			<br> <input id="fathername" type="text" name="fathername"
				value=<%=rs.getString("fathername")%>><br>
			<br> <input id="email" type="email" name="email"
				value=<%=rs.getString("email")%>><br>
			<br> <input id="class" type="number" name="class"
				value=<%=rs.getInt("class")%>><br>
			<br> <input id="age" type="number" name="age"
				value=<%=rs.getInt("age")%>><br>
			<br> <input type="submit" value="Submit"><br>
			<br>
		</fieldset>
		<%
			 con.close();
			 } catch (Exception ex) {
				 out.println("Unable to connect to database.");
			 }
		%>
	</form>

</body>
</html>
