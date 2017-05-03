package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addDept extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int did=Integer.valueOf(request.getParameter("did"));
		String dname=request.getParameter("dname");
		String location =request.getParameter("location");
		out.print("<h1>员工dept</h1>");
        out.print("<h1>did：" + did + "</h1>");
        out.print("<h1>部门：" + dname + "</h1>");
        out.print("<h1>地址：" + location + "</h1>");
		out.close();
	}

}
