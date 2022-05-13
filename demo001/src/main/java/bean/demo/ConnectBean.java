package bean.demo;

import java.sql.Connection;
import bean.demo.dataBean;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBean {
	     //���ݿ���Ϣ
	      String url = "jdbc:mysql://localhost:3306/Lab_DB"; 
	  	  String user = "root";   
	  	  String pwd = "admin"; 
	  	
	  	  private Connection conn;  //����
	  	  private Statement stmt_select;     //SQL���
	  	  private Statement stmt_delete;
	  	  private Statement stmt_update;
	  	  private Statement stmt_insert;
	      ResultSet rs;            //�����
	      
	     
	  	 	  
	      //ʵ����JavaBean�����ͬʱ�������ݿ�����
    public  ConnectBean() {
    	  try {
    		  Class.forName("com.mysql.cj.jdbc.Driver");
    		  conn=DriverManager.getConnection(url,user,pwd);
    	  }catch(Exception e) {
    		  e.printStackTrace();	
    	  }
    }
      

     public String access(String account) throws SQLException {
    	 
    	//"ѧ����Ȩ��ֻ��ʾ������¼������Ȩ����ʾ���м�¼�� 	 
    	 String sql = "select * from user where account='"+account+"'";
    	 dataBean test=new dataBean();
    	 ResultSet rs=selectSql(sql);
    	 
    	    if(rs.next() ) {
    	    	//System.out.println(rs.getString("access_rights"));
    	    	test.setAccess_rights(rs.getString("access_rights"));
    	    
    	 	   switch(rs.getString("access_rights")) {
    	 	      case "ѧ��":break;
    	 	      default: sql="select * from user";            
    	 	   }
    	 	   
    	    }
			return sql;
    	 
     }
     
     //��ѯ��¼
     public ResultSet selectSql(String sql) {
    	 
    	 try {
    		 stmt_select=conn.createStatement();
    		 rs = stmt_select.executeQuery(sql);
    	 }catch(SQLException e) {
    		 e.printStackTrace();	
    	 }
    	 
		return rs;    	 
   	 
     }
     
     //��Ӽ�¼
     public int insertSql(String sql) {
     	 
     	 try {
     		 stmt_insert=conn.createStatement();
     		 return stmt_insert.executeUpdate(sql); 
     	 }catch(SQLException e) {
     		 e.printStackTrace();	
     	 }
    	return 0;

      } 
     //ɾ����¼
  public int deleteSql(String sql) {
 	 
 	 try {
 		 stmt_delete=conn.createStatement();
 		 return stmt_delete.executeUpdate(sql); 
 	 }catch(SQLException e) {
 		 e.printStackTrace();	
 	 }
	return 0;

  } 
  //���¼�¼
  public int updateSql(String sql) {
 	 
 	 try {
 		 stmt_update=conn.createStatement();
 		 return stmt_update.executeUpdate(sql);  
 	 }catch(SQLException e) {
 		 e.printStackTrace();	
 	 }
 	 
		return 0;    	 
	 
  }
  
  //�ر����ݿ�����
     public void closeConn() {
    	 try {
    		 if(conn!=null)   
    			 conn.close();
    	 }catch(SQLException e) {
    		 e.printStackTrace();	
    	 }
    	
     }
	
}
