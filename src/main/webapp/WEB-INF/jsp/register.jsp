<%--
  Created by IntelliJ IDEA.
  User: zjzhou
  Date: 2021/11/3
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<% pageContext.setAttribute("path", request.getContextPath());%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>注册</title>



    <script language="javascript">
        function isValid(){
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var password2 = document.getElementById("password2").value;
            if(username.length > 0 && password == password2){
                //提交表单
                alert("注册成功!");
            }else{
                if(username.length==0){
                    alert("用户名不能为空");
                    return;
                }else if(password!=password2){
                    alert("两次输入不一致");
                    return;
                }
            }
        }
    </script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>

<div class="page-header" style="text-align: center;margin: auto">
    <h1>
        基于SSM框架的管理系统
    </h1>
    <h3>
        注册页
    </h3>
</div>


<!-- action要和后台的@RequestMapping的值保持一致 -->
<form name="register" action="" method="post"  >
    <table width="300" border="1" align="center">
        <tr>
            <td colspan="2">注册</td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input  type="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input  type="password" name="password2" id="password2">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册" onclick="isValid()" >
                &nbsp;&nbsp;&nbsp;&nbsp;已注册，请前往<a href="${path }">登录</a>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
