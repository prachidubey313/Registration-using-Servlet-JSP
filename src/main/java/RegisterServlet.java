
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // response.sendRedirect("registrationForm.jsp");
//    	request.setAttribute("message", "Registration successful!");
//        request.getRequestDispatcher("registrationConfirmation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  String firstname = request.getParameter("firstName");
    	  String lastname = request.getParameter("lastName");
    	  String address = request.getParameter("address");
    	  String contactNo = request.getParameter("contactNo");
  	      String password = request.getParameter("password");
  	      String email = request.getParameter("email");
  	      HttpSession session = request.getSession();
  	     session.setAttribute("name_key", firstname );
  	     session.setAttribute("email_key", email );


        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                // Create a prepared statement
                String sql = "INSERT INTO registration (firstname,lastname,address,contactNo, password, email) VALUES (?,?,?,?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, firstname);
                    preparedStatement.setString(2, lastname);
                    preparedStatement.setString(3, address);
                    preparedStatement.setString(4, contactNo);
                    preparedStatement.setString(5, password);
                    preparedStatement.setString(6, email);
                   

                    // Execute the update
                    preparedStatement.executeUpdate();
                    //request.setAttribute("message", "Registration successful!");
                    //request.getRequestDispatcher("registrationConfirmation.jsp").forward(request, response);
                   // request.setAttribute("message", "Registration successful!");
                   RequestDispatcher rd= request.getRequestDispatcher("registrationConfirmation.jsp");
                   rd.forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Log or handle the exception appropriately
        } catch (SQLException e) {
            e.printStackTrace();
            // Log or handle the exception appropriately
        }
    }
}

