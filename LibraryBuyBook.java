package com.library.buybooks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarybooks.dto.LibraryBooksDTO;
import com.librarybooksdao.LibraryBooksDAO;

public class LibraryBuyBook extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookname=req.getParameter("bookname");
		String authorname=req.getParameter("authorname");
		double quantity=Integer.parseInt(req.getParameter("buyquantity"));
		double price=Double.parseDouble(req.getParameter("price"));
		double totalprice=price*quantity;
		LibraryBooksDTO dto=new LibraryBooksDTO(bookname, authorname, price, quantity);
		LibraryBooksDAO dao=new LibraryBooksDAO();
		PrintWriter pw=resp.getWriter();
		try {
			if(dao.buybooks(dto)) {
				pw.println("<h1>"
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ ""
						+ "<pre>                                         <h2>Book Name:"+bookname+"</h2>"
								+ "										 <h2>Author Name:"+authorname+"</h2></pre>"
						+ "<pre>                                        <h2>Total Amount : "+totalprice+"</h2></pre>"
						+ " <pre>                                     <a href='order.html'><button>Confirm Order</button></a></pre>"
						+ "</h1>");
			}
			else {
				pw.println("<h1>Something Went Wrong....</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
