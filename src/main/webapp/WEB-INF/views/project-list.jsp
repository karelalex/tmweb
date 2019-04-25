<%@ page import="java.util.List" %>
<%@ page import="ru.karelin.tmweb.entity.Project" %><%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 24.04.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">
    <h1>Список проектов</h1>
    <table>
        <colgroup>
            <col class="number">
            <col class="id">
            <col class="name">
            <col class="desc">
        </colgroup>
        <tr>
            <th>№</th>
            <th>ID</th>
            <th>Имя</th>
            <th>Описание</th>
        </tr>
        <%List projects = (List<Project>) request.getAttribute("projects");%>
        <c:set scope="page" value="<%=projects%>" var="projects"/>
        <c:forEach items="${projects}" var="p" varStatus="iter">
            <tr>
                <td>${iter.count}</td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.description}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
