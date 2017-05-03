<%@ page contentType="text/html;charset=UTF-8" import="entity.*,java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    
    
    <title>My JSP 'updateEmp.jsp' starting page</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="wrap">
            <div id="top_content">
                    <div id="header">
                        <div id="rightheader">
                            <p>
                                2009/11/20
                                <br />
                            </p>
                        </div>
                        <div id="topheader">
                            <h1 id="title">
                                <a href="#">Main</a>
                            </h1>
                        </div>
                        <div id="navigation">
                        </div>
                    </div>
                <div id="content">
                    <p id="whereami">
                    </p>
                    <h1>
                        更新员工
                    </h1>
                    <%
                        employee emp = (employee)request.getAttribute("emp");                    
                    %>
                    <form action="update.do?id=<%=emp.getId()%>" method="post">
                        <table cellpadding="0" cellspacing="0" border="0"
                            class="form_table">
                            <tr>
                                <td valign="middle" align="right">
                                    编号:
                                </td>
                                <td valign="middle" align="left">
                                    <%=emp.getId()%>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    姓名:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="name" value="<%=emp.getName()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    薪水:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="salary" value="<%=emp.getSalary()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    年龄:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="age" value="<%=emp.getAge()%>"/>
                                </td>
                            </tr>
                        </table>
                        <p>
                            <input type="submit" class="button" value="修改" />
                        </p>
                    </form>
                </div>
            </div>
            <div id="footer">
                <div id="footer_bg">
                    ABC@126.com
                </div>
            </div>
        </div>
  </body>
</html>
