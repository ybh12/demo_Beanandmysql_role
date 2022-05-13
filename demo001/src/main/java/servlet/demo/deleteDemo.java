package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.demo.ConnectBean;
import java.sql.*;

@WebServlet("/deleteDemo")

public class deleteDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ConnectBean conn=new ConnectBean();

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String sql="delete from user where "+request.getQueryString();	
	    conn.deleteSql(sql);
        response.sendRedirect("connectbeanDemo.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
