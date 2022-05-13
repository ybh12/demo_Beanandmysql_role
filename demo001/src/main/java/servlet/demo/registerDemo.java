package servlet.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.demo.ConnectBean;


@WebServlet("/registerDemo")

public class registerDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	ConnectBean conn=new ConnectBean();
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		request.setCharacterEncoding("UTF-8");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String gender=request.getParameter("gender");
		String department=request.getParameter("department");
		String access_rights=null;
		
		//对不同的部门赋予不同的权限
		 switch(department){
		 case "信息部": access_rights="系统管理员";break;
		 case "教务部": access_rights="老师";break;
		 case "辅导员": access_rights="辅导员";break;
		 default: access_rights="学生";
		 }
		
		String sql="insert into user(account,password,username,gender,department,access_rights) values(\'"+account+"\',\'"+password+"\',\'"+username+"\',\'"+gender+"\',\'"+department+"\',\'"+access_rights+"\')";
	 //  System.out.println(sql);
	    conn.insertSql(sql);
       // response.sendRedirect("connectbeanDemo.jsp");
        response.sendRedirect("index.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
