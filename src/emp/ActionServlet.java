package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmplayeeDAO;
import entity.employee;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        // 获取请求资源路径中除应用名以外的部分
        String action = uri.substring(uri.lastIndexOf("/") + 1,
                uri.lastIndexOf("."));
        if (action.equals("list")) {
            try {
                EmplayeeDAO dao = new EmplayeeDAO();
                List<employee> emps = dao.findAll();
                request.setAttribute("emps", emps);
                request.getRequestDispatcher("listEmp.jsp").forward(request, response);
//                out.println("<table>");
//                out.println("<caption>员工信息列表</caption>");
//                out.println("<tr><td>编号</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");
//                for (employee emp : emps) {
//                    out.println("<tr>");
//                    out.println("<td>" + emp.getId() + "</td>");
//                    out.println("<td>" + emp.getName() + "</td>");
//                    out.println("<td>" + emp.getSalary() + "</td>");
//                    out.println("<td>" + emp.getAge() + "</td>");
//                    out.println("<td><a href='#'>删除</a>");
//                    out.println("<a href='#'>修改</a></td>");
//                    out.println("</tr>");
//                }
//                out.println("</table>");
//                out.println("<a href='addEmp.html'>增加新员工</a>");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("系统繁忙");
            }
        } else if (action.equals("add")) {
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));
            int age = Integer.parseInt(request.getParameter("age"));
            try {
                employee emp = new employee();
                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                EmplayeeDAO dao = new EmplayeeDAO();
                dao.save(emp);
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("系统繁忙");
            }
        }else if(action.equals("delete")){
        	int id=Integer.parseInt(request.getParameter("id"));
        	EmplayeeDAO dao = new EmplayeeDAO();
        	try {
				dao.delete(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action.equals("load")){
        	int id=Integer.parseInt(request.getParameter("id"));
        	EmplayeeDAO dao = new EmplayeeDAO();
        	employee emp = new employee();
			try {
				emp = dao.findById(id);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action.equals("update")){
        	int id= Integer.parseInt(request.getParameter("id"));
        	String name=request.getParameter("name");
        	double salary =Double.parseDouble(request.getParameter("salary"));
        	int age =Integer.parseInt(request.getParameter("age"));
        	employee emp = new employee();
        	EmplayeeDAO dao = new EmplayeeDAO();
        	emp.setName(name);
        	emp.setAge(age);
        	emp.setId(id);
        	emp.setSalary(salary);
        	try {
				dao.modify(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}


