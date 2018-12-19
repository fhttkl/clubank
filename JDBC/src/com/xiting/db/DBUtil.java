package com.xiting.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {


	 public static void main(String [] args)

	 {

	  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	  String dbURL="jdbc:sqlserver://192.168.0.7:49311;DatabaseName=Golf75_SHXT705";

	  String userName="sa";

	  String userPwd="Sein2012";

	  try
	  {
	   Class.forName(driverName);

	   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);

	    System.out.println("连接数据库成功");

	  }

	  catch(Exception e)

	  {

	   e.printStackTrace();

	   System.out.print("连接失败");

	  }    

	 }

}
