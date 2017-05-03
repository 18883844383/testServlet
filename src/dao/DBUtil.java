package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&characterEncoding=utf-8","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
	
}
