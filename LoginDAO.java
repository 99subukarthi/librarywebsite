package com.logindao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbutil.DBConnection;
import com.logindto.LoginDTO;

public class LoginDAO {
	
	
	public String checkuser(LoginDTO dto) throws Exception {
		String username=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DBConnection.getconnection();
		String sql="SELECT * FROM LOGINUSER WHERE MAILID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,dto.getUsername());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getString(3).equals(dto.getPassword())) {
				username=rs.getString(1);
			}
			else {
				username=null;
			}
		}
		else {
			username=null;
		}
		return username;
	}
}
