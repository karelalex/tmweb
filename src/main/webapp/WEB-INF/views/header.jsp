<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 24.04.2019
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
<title>Title</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css" />
</head>
<body>
<div class="header">
    <h1>Планировщик задач</h1>
    <ul>
        <li><a href="<%=request.getContextPath()%>/">Главная</a></li>
        <li><a href="<%=request.getContextPath()%>/showproject">Проекты</a></li>
        <li><a href="<%=request.getContextPath()%>/showtask">Задачи</a></li>
    </ul>
</div>
