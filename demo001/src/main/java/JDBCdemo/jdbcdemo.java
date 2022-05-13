package JDBCdemo;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcdemo {
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("成功加载mysql数据库驱动程序！");
		}
		catch(Exception e) 
		{
			System.out.println("加载sql程序时出现错误！");
			e.printStackTrace();
			
		}
		try {
			//链接数据库
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db","root","admin");
			System.out.println("成功连接数据库！");
		}
		catch(Exception e){
			System.out.println("连接数据失败！");
			e.printStackTrace();
		}
	}

}
