<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>修改内容</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="text-align: center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统
                </h1>
                <h3>
                    修改页
                </h3>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改内容</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="contentId" value="${content.contentId}"/>
        名称：
        <label>
            <input type="text" name="contentName" value="${content.contentName}"/>
        </label>
        数量 ：
        <label>
            <input type="text" name="contentNum" value="${content.contentNum}"/>
        </label>
        详情 ：
        <label>
            <input type="text" name="contentDetail" value="${content.contentDetail}"/>
        </label>
        <input type="button" value="提交" onclick="updateContent()"/>
    </form>
    <script type="text/javascript">
        function updateContent() {
            var form = document.forms[0];
            form.action = "<%=basePath %>content/updateContent";
            form.method = "post";
            form.submit();
        }
    </script>
</div>