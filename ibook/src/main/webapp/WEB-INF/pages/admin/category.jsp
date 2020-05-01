<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="top.jsp"/>
<section class="banner">
    <div class="container">
        <div>
            <h1>图书</h1>
            <p>图书分类列表</p>
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
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="c">
                <tr>
                    <td>${c.name}</td>
                    <td><fmt:formatDate value='${c.createTime}' pattern='yyyy-MM-dd HH:mm:ss' type="both"/></td>
                    <td><fmt:formatDate value='${c.updateTime}' pattern='yyyy-MM-dd HH:mm:ss' type="both"/></td>
                    <td>
                        <a href="/admin/Category/remove.do?id=${c.id}">删除</a>
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

            <a href="${pageContext.request.contextPath}/admin/Category/toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>

