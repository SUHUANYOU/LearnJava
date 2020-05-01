<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>新建</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="">
                慕课网科室修改
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, ${USER.username}!</h1>
        <p>请小心的修改科室记录，要是增加一个错误的就不好了。。。</p>
    </div>
    <div class="page-header">
        <h3>
            <small>科室修改</small>
        </h3>
    </div>
    <form class="form-horizontal" action="edit.do?id=${OBJ.id}&cid=${OBJ.categoryId}" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" value="${OBJ.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
            <select id="categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto">

                <c:forEach items="${CLIST}" var="category">
                    <c:if test="${OBJ.categoryId == category.id}">
                        <option value="${category.id}" selected="selected">${category.name}</option>
                    </c:if>
                    <c:if test="${OBJ.categoryId!=category.id}">
                        <option value="${category.id}">${category.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center">
    copy@imooc
</footer>
</body>
</html>
