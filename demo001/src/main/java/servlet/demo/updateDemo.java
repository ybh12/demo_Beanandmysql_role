package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.demo.ConnectBean;
import java.sql.*;

@WebServlet("/updateDemo")
public class updateDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ConnectBean conn=new ConnectBean();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
		    PrintWriter out=response.getWriter();
		    HttpSession session=request.getSession(); 
		    
  if(request.getParameter("update_submit")==null) {
	 
	  session.setAttribute("whereClause",request.getQueryString());	 
	  
	   out.println("<!DOCTYPE html><html>");
	   out.println("<form action=\"updateDemo\" method=\"get\">");
	   out.println("<label>用户：</label>");
	   out.println("<input type=\"text\" name=\"username\"/><br>");
	   out.println("<label>性别：</label>");
	   out.println("<select name='gender'>");
	   out.println("<option>男</option>\n");
	   out.println("<option>女</option>\n");
	   out.println("</select><br>");
	   out.println("<label>所属部门：</label>");
	   out.println("<select name='department'>");
	   out.println("<option>1班</option>\n");
	   out.println("<option>2班</option>\n");
	   out.println("<option>3班</option>\n");
	   out.println("<option>4班</option>");
	   out.println("<option>辅导员</option>");
	   out.println("<option>信息部</option>");
	   out.println("<option>教务部</option>");
	   out.println("</select><br><br>");
	   out.println("<input type=\"submit\" name=\"update_submit\" value=\"提交修改\"/><br>\n"+ "</form></html>");
	   
	  }else {   
	       //根据“所属部门”，赋于对应权限
		  String access_rights;
		  switch(request.getParameter("department")) {
		     case "信息部": access_rights="系统管理员";break;
			 case "教务部": access_rights="老师";break;
			 case "辅导员": access_rights="辅导员";break;
			 default: access_rights="学生";
	     }
      String sql="update user set username=\""+request.getParameter("username")+"\", gender=\""+request.getParameter("gender")+"\",department=\""+request.getParameter("department")+"\",access_rights=\""+access_rights+"\"  where "+ session.getAttribute("whereClause");
		// System.out.println(sql);
	      conn.updateSql(sql);
          response.sendRedirect("connectbeanDemo.jsp");  
	   }  
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
