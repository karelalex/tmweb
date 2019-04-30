<%@ page import="ru.karelin.tmweb.entity.Task" %>
<%@ page import="java.util.List" %>
<%--
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
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">
    <h1>Список задач</h1>
    <table>
        <colgroup>
            <col class="number">
            <col class="id">
            <col class="id">
            <col class="name">
            <col class="desc">
            <col class="action">
        </colgroup>
        <tr>
            <th>№</th>
            <th>ID</th>
            <th>ID Проекта</th>
            <th>Имя</th>
            <th>Описание</th>
            <th>Действия</th>
        </tr>
        <%List<Task> tasks = (List<Task>)request.getAttribute("tasks");%>
        <c:set scope="page" value="<%=tasks%>" var="tasks"/>
        <c:forEach items="${tasks}" var="t" varStatus="iter">
            <tr>
                <td>${iter.count}</td>
                <td>${t.id}</td>
                <td><a href="<%=request.getContextPath()%>/showproject?pid=${t.projectId}">${t.projectId}</a></td>
                <td>${t.name}</td>
                <td>${t.description}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/showtask?tid=${t.id}"><i class="fas fa-receipt"></i></a>&nbsp;
                    <a href="<%=request.getContextPath()%>/edittask?tid=${t.id}"><i class="fas fa-edit"></i></a>&nbsp;
                    <a href="<%=request.getContextPath()%>/removetask?tid=${t.id}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%String projectId = request.getParameter("pid");%>
    <c:set scope="page" value="<%=projectId%>" var="pid" />
    <div class="but-cover margin_5">
        <c:if test="${pid==null || pid.length()==0}">
        <a href="<%=request.getContextPath()%>/createtask"> <button type="button">Создать</button></a>
        </c:if>
        <c:if test="${pid!=null && pid.length()>0}">
            <a href="<%=request.getContextPath()%>/createtask?pid=${pid}"> <button type="button">Создать</button></a>
        </c:if>
    </div>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
