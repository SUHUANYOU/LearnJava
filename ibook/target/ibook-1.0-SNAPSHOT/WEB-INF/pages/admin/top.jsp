<%--
  Created by IntelliJ IDEA.
  User: ritatadang
  Date: 2020/4/3
  Time: 4:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">
        <c:forEach items="${categories}" var="c">
            <nav>
                <a href="${pageContext.request.contextPath}/admin/Book/toBooks.do?id=${c.id}">${c.name}</a>
            </nav>
        </c:forEach>
        <nav>
            <a href="${pageContext.request.contextPath}/admin/Category/toList.do">分类</a>
        </nav>
    </div>
</header>

