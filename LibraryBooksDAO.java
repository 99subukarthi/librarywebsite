package com.librarybooksdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbutil.DBConnection;
import com.librarybooks.dto.LibraryBooksDTO;

public class LibraryBooksDAO {
  public boolean buybooks(LibraryBooksDTO dto) throws Exception {
	  boolean result=true;
	  Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DBConnection.getconnection();
		String sql="SELECT * FROM LIBRARYBOOKS WHERE BOOKNAME=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, dto.getBookname());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			if(update(dto)) {
				result=true;
			}
		}
		else {
			result= false;
		}
		return result;
  }

private boolean update(LibraryBooksDTO dto) throws Exception {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DBConnection.getconnection();
		String squery="SELECT * FROM LIBRARYBOOKS WHERE BOOKNAME=?";
		PreparedStatement pstmt=con.prepareStatement(squery);
		pstmt.setString(1, dto.getBookname());
		ResultSet rs=pstmt.executeQuery();
		int noru=0;
		if(rs.next()) {
			double newquantity=rs.getDouble(3)-dto.getQuantity();
			String uquery="UPDATE LIBRARYBOOKS SET BOOKQUANTITY=? WHERE BOOKNAME=?";
			pstmt=con.prepareStatement(uquery);
			pstmt.setDouble(1, newquantity);
			pstmt.setString(2, dto.getBookname());
			 noru=pstmt.executeUpdate();
		}
		return noru==1;
}
}
