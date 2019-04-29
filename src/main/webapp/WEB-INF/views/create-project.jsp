<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.karelin.tmweb.entity.Project" %>
<%@ page import="ru.karelin.tmweb.enumeration.Status" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 25.04.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">

    <h1>Описание проекта</h1>
    <form action="<%=request.getContextPath()%>/createproject" method="post" enctype="application/x-www-form-urlencoded">
        <div class="prop-cover">
            <div class="prop-name"><p>Название</p></div>
            <div class="prop-desc">
                <input type="text" name="name" value="" placeholder="Название проекта"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Описание</p></div>
            <div class="prop-desc"><textarea rows="3" name="desc" placeholder="Описание проекта"></textarea>
            </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата начала</p></div>
            <div class="prop-desc"><input type="date"
                                          name="startDate"
                                          value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата окончания</p></div>
            <div class="prop-desc"><input type="date" name="finishDate"
                                          value="<fmt:formatDate value="<%=new Date()%>"  pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>
        <div class="but-cover">
            <button type="submit">Отправить</button>
        </div>
    </form>


</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
