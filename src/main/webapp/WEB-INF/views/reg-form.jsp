<%@ page import="ru.karelin.tmweb.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Регистрация нового пользователя</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">
    <h1>Регистрация нового пользователя</h1>
    <%String message = (String)request.getAttribute("message");%>
    <c:set scope="page" value="<%=message%>" var="message"/>
    <%User user = (User)request.getAttribute("tempuser");%>
    <c:set var="tuser" value="<%=user%>" scope="page"/>
    <c:if test="${message!=null}">
    <p class="message">${message}</p>
    </c:if>
    <form action="<%=request.getContextPath()%>/reg" method="post" enctype="application/x-www-form-urlencoded">

        <div class="prop-cover">
            <div class="prop-name"><p>Логин</p></div>
            <div class="prop-desc">
                <input type="text" name="login" value="${tuser!=null ? tuser.login : ''}" placeholder="Логин"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Пароль</p></div>
            <div class="prop-desc">
                <input type="password" name="pass" value="" placeholder="Пароль"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Повторите пароль</p></div>
            <div class="prop-desc">
                <input type="password" name="passRepeat" value="" placeholder="Пароль"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Имя пользователя</p></div>
            <div class="prop-desc">
                <input type="text" name="userName" value="${tuser!=null ? tuser.username : ''}" placeholder="Иванов Иван Иваныч"/></div>
        </div>
        <div class="but-cover margin_10">
            <button type="submit">Отправить</button>
        </div>
    </form>


</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
