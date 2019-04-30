<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.karelin.tmweb.entity.Project" %>
<%@ page import="ru.karelin.tmweb.enumeration.Status" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.karelin.tmweb.entity.Task" %><%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 25.04.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание задачи</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">

    <h1>Редактирование задачи</h1>
    <form action="<%=request.getContextPath()%>/edittask" method="post" enctype="application/x-www-form-urlencoded">
        <%Task task = (Task) request.getAttribute("task");%>
        <c:set var="task" value="<%=task%>" scope="page"/>
        <div class="prop-cover">
            <div class="prop-name"><p>Id</p></div>
            <div class="prop-desc">${task.id}</div>
            <input value="${task.id}" name="tid" type="hidden">
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Проект</p></div>
            <div class="prop-desc">
                <c:set var="projectId" value="${task.projectId}" scope="page"/>
                <%List<Project> projectList = (List<Project>) request.getAttribute("projects");%>
                <select name="pid">
                    <c:forEach var="project" items="<%=projectList%>">
                        <option value="${project.id}"  ${project.id.equals(projectId) ? 'selected="selected"' : ''} >${project.name}</option>
                    </c:forEach>
                </select></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Название</p></div>
            <div class="prop-desc">
                <input type="text" name="name" value="${task.name}" placeholder="Название задачи"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Описание</p></div>
            <div class="prop-desc"><textarea rows="3" name="desc" placeholder="Описание задачи">${task.description}</textarea>
            </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата начала</p></div>
            <div class="prop-desc"><input type="date"
                                          name="startDate"
                                          value="<fmt:formatDate value="${task.startingDate}" pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Дата окончания</p></div>
            <div class="prop-desc"><input type="date" name="finishDate"
                                          value="<fmt:formatDate value="${task.finishDate}"  pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Текущий статус</p></div>
            <div class="prop-desc"><select name="status">
                <c:forEach var="stat" items="<%=Status.values()%>">
                    <option value="${stat.name()}" ${stat.name() == task.status.name() ? 'selected="selected"' : ''}>${stat.displayName}</option>
                </c:forEach>
            </select></div>
        </div>
        <div class="but-cover margin_10">
            <button type="submit">Отправить</button>
        </div>
    </form>


</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
