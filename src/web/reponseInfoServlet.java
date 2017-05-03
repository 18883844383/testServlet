package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class reponseInfoServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
						throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("能够输出中文信息的Servlet");
		out.close();
	}
}
