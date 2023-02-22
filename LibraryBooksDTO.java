package com.librarybooks.dto;

public class LibraryBooksDTO {
	String bookname;
	String authorname;
	double bookprice;
	double quantity;
	public LibraryBooksDTO() {
	}
	public LibraryBooksDTO(String bookname, String authorname, double bookprice, double quantity) {
		this.bookname = bookname;
		this.authorname = authorname;
		this.bookprice = bookprice;
		this.quantity = quantity;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
