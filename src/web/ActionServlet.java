package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1,
                uri.lastIndexOf("."));            
        // 判断动作是否为登录
        if (action.equals("login")) {
            String name = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String number = request.getParameter("vcode");
            HttpSession session = request.getSession();
            String code = session.getAttribute("code").toString();
            if (number.equals(code) && name.equals("111") && pwd.equals("111")) {
                // 编程式--设定session超时时间为10秒
                //session.setMaxInactiveInterval(10);
                session.setAttribute("uname", name);
                // 重定向到首页
                //response.sendRedirect("index.jsp");
                 response.sendRedirect(
                 response.encodeRedirectURL("index.jsp"));
            } else {
                // 登录失败
                request.setAttribute("msg", "用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,
                        response);
            }
        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            // session失效
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
        out.close();
    }

}
