<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 24.04.2019
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <h1>Планировщик задач</h1>
    <ul>
        <%String userId = (String)request.getSession().getAttribute("userId");%>
        <c:set var="userId" value="<%=userId%>" scope="page"/>
        <li><a href="<%=request.getContextPath()%>/">Главная</a></li>
        <c:if test="${userId==null}">
            <li><a href="<%=request.getContextPath()%>/login">Вход</a></li>
        </c:if>
        <c:if test="${userId!=null}">
            <li><a href="<%=request.getContextPath()%>/showproject">Проекты</a></li>
            <li><a href="<%=request.getContextPath()%>/showtask">Задачи</a></li>
            <li><a href="<%=request.getContextPath()%>/logout">Выход</a></li>
        </c:if>
    </ul>
</div>
