package com.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBConnection;

public class UserSignUp extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String mailid=req.getParameter("mailid");
		String password=req.getParameter("password");
		PrintWriter pw=resp.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DBConnection.getconnection();
			PreparedStatement pstmt=con.prepareStatement("insert into loginuser values(?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, mailid);
			pstmt.setString(3, password);
			int nori=pstmt.executeUpdate();
			if(nori==1) {
				pw.println("<h1>SignUp Completed...</h1>");
				pw.println("<button><a href='LibraryLogin.html'>Click Here To SignIn...</a></button>");
			}
			else {
				pw.println("<h1>Something Went Wrong</h1>");
				pw.println("<button><a href='landing.html'>Click Here To SignUp...</a></button>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
