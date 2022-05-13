package bean.demo;

import java.sql.Connection;
import bean.demo.dataBean;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBean {
	     //数据库信息
	      String url = "jdbc:mysql://localhost:3306/Lab_DB"; 
	  	  String user = "root";   
	  	  String pwd = "admin"; 
	  	
	  	  private Connection conn;  //连接
	  	  private Statement stmt_select;     //SQL语句
	  	  private Statement stmt_delete;
	  	  private Statement stmt_update;
	  	  private Statement stmt_insert;
	      ResultSet rs;            //结果集
	      
	     
	  	 	  
	      //实例化JavaBean对象的同时创建数据库连接
    public  ConnectBean() {
    	  try {
    		  Class.forName("com.mysql.cj.jdbc.Driver");
    		  conn=DriverManager.getConnection(url,user,pwd);
    	  }catch(Exception e) {
    		  e.printStackTrace();	
    	  }
    }
      

     public String access(String account) throws SQLException {
    	 
    	//"学生“权限只显示单个记录，其他权限显示所有记录； 	 
    	 String sql = "select * from user where account='"+account+"'";
    	 dataBean test=new dataBean();
    	 ResultSet rs=selectSql(sql);
    	 
    	    if(rs.next() ) {
    	    	//System.out.println(rs.getString("access_rights"));
    	    	test.setAccess_rights(rs.getString("access_rights"));
    	    
    	 	   switch(rs.getString("access_rights")) {
    	 	      case "学生":break;
    	 	      default: sql="select * from user";            
    	 	   }
    	 	   
    	    }
			return sql;
    	 
     }
     
     //查询记录
     public ResultSet selectSql(String sql) {
    	 
    	 try {
    		 stmt_select=conn.createStatement();
    		 rs = stmt_select.executeQuery(sql);
    	 }catch(SQLException e) {
    		 e.printStackTrace();	
    	 }
    	 
		return rs;    	 
   	 
     }
     
     //添加记录
     public int insertSql(String sql) {
     	 
     	 try {
     		 stmt_insert=conn.createStatement();
     		 return stmt_insert.executeUpdate(sql); 
     	 }catch(SQLException e) {
     		 e.printStackTrace();	
     	 }
    	return 0;

      } 
     //删除记录
  public int deleteSql(String sql) {
 	 
 	 try {
 		 stmt_delete=conn.createStatement();
 		 return stmt_delete.executeUpdate(sql); 
 	 }catch(SQLException e) {
 		 e.printStackTrace();	
 	 }
	return 0;

  } 
  //更新记录
  public int updateSql(String sql) {
 	 
 	 try {
 		 stmt_update=conn.createStatement();
 		 return stmt_update.executeUpdate(sql);  
 	 }catch(SQLException e) {
 		 e.printStackTrace();	
 	 }
 	 
		return 0;    	 
	 
  }
  
  //关闭数据库连接
     public void closeConn() {
    	 try {
    		 if(conn!=null)   
    			 conn.close();
    	 }catch(SQLException e) {
    		 e.printStackTrace();	
    	 }
    	
     }
	
}
