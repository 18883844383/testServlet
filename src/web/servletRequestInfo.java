package web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletRequestInfo extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse respondse)
						throws ServletException,IOException{
		Enumeration e =request.getHeaderNames();
		while(e.hasMoreElements()){
			String headerName=e.nextElement().toString();
			System.out.println(headerName+":"+request.getHeader(headerName));
		}
		System.out.println("请求方式："+request.getMethod());
		System.out.println("请求的协议种类："+request.getProtocol());
		System.out.println("请求的资源路径："+request.getRequestURI());
		System.out.println("请求的路径信息："+request.getRequestURL());
		System.out.println("请求的Servlet路径："+request.getServletPath());
	}
}
