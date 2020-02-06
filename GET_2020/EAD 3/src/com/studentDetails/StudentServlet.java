package com.studentDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentDetails.DBConnection;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DBConnection.initializeDatabase();  //Initialized the DB
			PreparedStatement st = conn.prepareStatement("insert into student (firstname,lastname,fathername,email,class,age) values( ?, ?, ?, ?, ?, ?)");
			st.setString(1, request.getParameter("fName"));
			st.setString(2, request.getParameter("lName"));
			st.setString(3, request.getParameter("fatherName"));
			st.setString(4, request.getParameter("emailId"));
			st.setInt(5, Integer.valueOf(request.getParameter("class")));
			st.setInt(6, Integer.valueOf(request.getParameter("age")));
			st.executeUpdate();
			st.close();
			conn.close();
			//To display the successful result
			PrintWriter out = response.getWriter();
			out.println("Successfully Inserted");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
