<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>    
        <title>Insert title here</title>
        <style type="text/css">
            .s1{
                cursor:pointer;
            }
        </style>
    </head>
    <body>
    <h3>登录</h3>
    <form action="login.do" method="post">
        用户名：<input name="uname"/><Br><br>
        密码：<input name="pwd" type="password"/><br><Br>
        验证码：<input name="vcode"/>
        <img src="code" onclick="this.src='code?'+Math.random();" 
        class="s1" title="点击更换" /><br><Br>
        <input type="submit" value="登录"/>
    </form>
    </body>
</html>