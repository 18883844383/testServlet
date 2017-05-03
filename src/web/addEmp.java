package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class addEmp extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		double salary =Integer.valueOf(request.getParameter("salary")); 
		int age=Integer.valueOf(request.getParameter("age"));
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&characterEncoding=utf-8", "root", "");
				ps=(PreparedStatement) conn.prepareStatement("insert into t_emp values" +
                    "(null,?,?,?)");
				ps.setString(1, name);
				ps.setDouble(2, salary);
				ps.setInt(3, age);
				ps.executeUpdate();
				out.println("添加成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("系统繁忙，稍后重试");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		out.close();
	}

}
