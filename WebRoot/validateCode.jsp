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
        验证码：<input name="vcode"/>
        <img src="code" onclick="this.src='code?'+Math.random();" 
        class="s1" title="点击更换" />
    </body>
</html>