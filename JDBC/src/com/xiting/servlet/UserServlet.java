package com.xiting.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		  String dbURL="jdbc:sqlserver://192.168.0.7:1433;DatabaseName=Golf75_SHXT705";

		  String userName="sa";

		  String userPwd="Sein2012";

		  try

		  {

		   Class.forName(driverName);

		   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		   Statement stmt=dbConn.createStatement();
		   ResultSet rs=stmt.executeQuery("select * from T_User");
		   ResultSetMetaData rsmd=rs.getMetaData();
		   int count=rsmd.getColumnCount();

		    System.out.println("连接数据库成功");
		    request.setAttribute("count", count);
		    request.getRequestDispatcher("success.jsp").forward(request, response);

		  }

		  catch(Exception e)

		  {
			  
			  request.setAttribute("msg", "链接数据库异常"+e.getMessage());
			    request.getRequestDispatcher("error.jsp").forward(request, response);

		  }    
		  
		  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
