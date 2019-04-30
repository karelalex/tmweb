<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.karelin.tmweb.entity.Task" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 25.04.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Описание задачи</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">
    <% Task task = (Task) request.getAttribute("task");%>
      <c:set scope="page" var="task" value="<%=task%>" />
    <c:if test="${task==null}">
        <h1>Проекта с указанным id  не существует</h1>
    </c:if>
    <c:if test="${task!=null}">
        <h1>Описание проекта</h1>
        <div class="prop-cover">
            <div class="prop-name"><p>Id</p></div>
            <div class="prop-desc">${task.id}</div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Id Проекта</p></div>
            <div class="prop-desc">${task.projectId}</div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Название</p></div>
            <div class="prop-desc">${task.name}</div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Описание</p></div>
            <div class="prop-desc">${task.description}</div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата начала</p></div>
            <div class="prop-desc"><fmt:formatDate value="${task.startingDate}" dateStyle="long" type="date" /> </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата окончания</p></div>
            <div class="prop-desc"><fmt:formatDate value="${task.finishDate}" dateStyle="long" type="date"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Текущий статус</p></div>
            <div class="prop-desc">${task.status.displayName}</div>
        </div>
        <div class="but-cover">
            <a href="<%=request.getContextPath()%>/edittask?tid=${task.id}"> <button type="button">Редактировать</button></a>
        </div>
    </c:if>



</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
