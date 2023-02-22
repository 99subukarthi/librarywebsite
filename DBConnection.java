package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;


import static com.dbutil.DBConstant.*;
public class DBConnection {
 public static Connection getconnection() throws Exception {
	 Connection con=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	 return con;
 }
}
