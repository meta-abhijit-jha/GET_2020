package com.studentDetails;
import java.sql.*;
public class DBConnection {
	protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/student"; 
        String dbUsername = "root"; 
        String dbPassword = "root";
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        return conn;
	}
}
