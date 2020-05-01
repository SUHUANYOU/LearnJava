<%--
  Created by IntelliJ IDEA.
  User: riatatadang
  Date: 2020/4/21
  Time: 4:43 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室列表</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">


        <c:forEach items="${CLIST}" var="category">

            <nav>
                <a href="../dept/list.do?cid=${category.id}">${category.name}</a>
            </nav>

        </c:forEach>
        <nav>
            <a href="list.do">分类</a>
        </nav>
        <nav>
            <a href="../logout.do">退出登录</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室分类列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${CLIST}" var="cat">
                <tr>
                    <td>${cat.name}</td>
                    <td><fmt:formatDate value="${cat.createTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
                    <td><fmt:formatDate value="${cat.updateTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
                    <td>

                        <a href="toEdit.do?id=${cat.id}">修改</a>&nbsp;&nbsp;
                        <a href="remove.do?id=${cat.id}">删除</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>