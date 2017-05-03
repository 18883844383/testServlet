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
import com.mysql.jdbc.ResultSet;

public class listEmpServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&characterEncoding=utf-8", "root", "");
				stat=(PreparedStatement) conn.prepareStatement("select * from t_emp");
				rs = (ResultSet) stat.executeQuery();
				out.println("<HTML>");
	            out.println("<HEAD></HEAD>");
	            out.println("<BODY>");
	            out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
	            out.println("<caption>员工信息列表</caption>");
	            out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td></tr>");
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                double salary = rs.getDouble("salary");
	                int age = rs.getInt("age");
	                out.println("<tr><td>"+
	                        id+"</td><td>"+
	                        name+"</td><td>"+
	                        salary+"</td><td>"+
	                        age+"</td></tr>");
	            }
	            out.print("</table>");
	            out.print("<a href='addEmp.html'>增加员工信息</a>");
	            out.println("</BODY>");
	            out.println("</HTML>");
	            out.flush();
	            out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.println("系统繁忙，请稍后重试");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		
	}

}
