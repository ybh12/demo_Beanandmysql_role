package JDBCdemo;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcdemo {
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�ɹ�����mysql���ݿ���������");
		}
		catch(Exception e) 
		{
			System.out.println("����sql����ʱ���ִ���");
			e.printStackTrace();
			
		}
		try {
			//�������ݿ�
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db","root","admin");
			System.out.println("�ɹ��������ݿ⣡");
		}
		catch(Exception e){
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
	}

}
