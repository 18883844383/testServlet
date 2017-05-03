package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"UTF-8");
		out.println("<h1>hello,"+name+"</h1>");
		
		String[] contacts =request.getParameterValues("contact");
		if(contacts!=null){
			out.println("<h1>contact information:</h1>");
			for(String info :contacts){
				out.println("<h1>"+info+"</h1>");
			}
		}
		out.close();
	}

}
