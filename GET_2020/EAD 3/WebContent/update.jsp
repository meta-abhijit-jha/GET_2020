<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update of Query Execution Page</title>
</head>
<body>
		<%
			int id = Integer.parseInt(request.getParameter("id").trim());
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String fathername = request.getParameter("fathername");
			String email = request.getParameter("email");
			int classStudent = Integer.parseInt(request.getParameter("class"));
			int age = Integer.parseInt(request.getParameter("age"));
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
				PreparedStatement ps = con.prepareStatement( "Update student set firstName=?,lastName=?,fatherName=?,email=?,class=?,age=? where studentId=?");
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, fathername);
				ps.setString(4, email);
				ps.setInt(5, classStudent);
				ps.setInt(6, age);
				ps.setInt(7, id);
				if ( ps.executeUpdate() > 0) 
					out.print("Record Updated Successfully");
				else 
					out.print("There is a problem in updating Record.");
			} catch (SQLException sql) {
				out.println(sql);
			}
			
			%>

	
	</body>
</html>
