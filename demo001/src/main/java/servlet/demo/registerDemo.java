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
		
		//�Բ�ͬ�Ĳ��Ÿ��費ͬ��Ȩ��
		 switch(department){
		 case "��Ϣ��": access_rights="ϵͳ����Ա";break;
		 case "����": access_rights="��ʦ";break;
		 case "����Ա": access_rights="����Ա";break;
		 default: access_rights="ѧ��";
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
