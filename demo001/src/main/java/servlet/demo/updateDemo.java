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
	   out.println("<label>�û���</label>");
	   out.println("<input type=\"text\" name=\"username\"/><br>");
	   out.println("<label>�Ա�</label>");
	   out.println("<select name='gender'>");
	   out.println("<option>��</option>\n");
	   out.println("<option>Ů</option>\n");
	   out.println("</select><br>");
	   out.println("<label>�������ţ�</label>");
	   out.println("<select name='department'>");
	   out.println("<option>1��</option>\n");
	   out.println("<option>2��</option>\n");
	   out.println("<option>3��</option>\n");
	   out.println("<option>4��</option>");
	   out.println("<option>����Ա</option>");
	   out.println("<option>��Ϣ��</option>");
	   out.println("<option>����</option>");
	   out.println("</select><br><br>");
	   out.println("<input type=\"submit\" name=\"update_submit\" value=\"�ύ�޸�\"/><br>\n"+ "</form></html>");
	   
	  }else {   
	       //���ݡ��������š������ڶ�ӦȨ��
		  String access_rights;
		  switch(request.getParameter("department")) {
		     case "��Ϣ��": access_rights="ϵͳ����Ա";break;
			 case "����": access_rights="��ʦ";break;
			 case "����Ա": access_rights="����Ա";break;
			 default: access_rights="ѧ��";
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
