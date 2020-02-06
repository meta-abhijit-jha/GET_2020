package com.studentDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentDetails.DBConnection;

/**
 * Servlet implementation class ExtractDetails
 */
@WebServlet("/ExtractDetails")
public class ExtractDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExtractDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Connection conn = DBConnection.initializeDatabase(); // Initialized the DB
			PreparedStatement st = conn.prepareStatement("select * from student");
			ResultSet rs = st.executeQuery();
			out.println("<html><body>");
			out.println("<table>");
			out.println("<tr><th>First Name</th><th>Last Name</th><th>Father</th><th>Email</th><th>Class</th><th>Age</th></tr>");
			while (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				String fatherName = rs.getString(4);
				String emailId = rs.getString(5);
				int classStudent = rs.getInt(6);
				int age = rs.getInt(7);
				out.println("<tr><td>" + fName + "</td><td>" + lName + "</td><td>" + fatherName + "</td><td>" + emailId
						+ "</td><td>" + classStudent + "</td><td>" + age + "</td><td>"
						+ "<td><a href = updateStudent.jsp?id=" + id 
						+ "><button>"+"Update"+"</button></a>"+"</td></tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			st.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
