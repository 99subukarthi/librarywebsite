package com.library.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logindao.LoginDAO;
import com.logindto.LoginDTO;

public class LibraryLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String mailid=req.getParameter("username");
			String password=req.getParameter("password");
			LoginDTO dto=new LoginDTO(mailid, password);
			LoginDAO dao=new LoginDAO();
			PrintWriter pw=resp.getWriter();
			try {
				String username=dao.checkuser(dto);
				if(username!=null) {
					
					
					pw.println("<pre>"
							+ "                                      <h1>Login Successfull..</h1>"
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ "                                      <h1>Welcome Mr/Mrs: "+username+"</h1>"
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ "										<h1><a href='library.html'>Go To Library Page</a></h1>"
							+ ""
							+ ""
							+ "</pre>");
				}
				else {
					
					pw.println("<pre>"
							+ "                                      <h1>Login Failed..</h1>"
							+ ""
							+ "<h1>Invalid Username Or Password \n"
							+ "Please Check Your Username & Password.</h1>"
							+ ""
							+ "<h1><a href='LibraryLogin.html'>Go To Login Page<a></h1>"
							+ ""
							+ "");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
