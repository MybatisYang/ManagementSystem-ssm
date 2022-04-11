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
    <title>登录</title>
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
        登录页
    </h3>
</div>

<!-- action要和后台的@RequestMapping的值保持一致 -->
<form name="form1" action="login" method="post" >
    <table width="300" border="1" align="center">
        <tr>
            <td colspan="2">登录</td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input  type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="登录"/>
                <span style="position: center">&nbsp;&nbsp;&nbsp;&nbsp;如果还未注册，请前往<a href="${path }/register">注册</a></span>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
