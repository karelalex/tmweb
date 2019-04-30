<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.karelin.tmweb.entity.Project" %>
<%@ page import="ru.karelin.tmweb.enumeration.Status" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 25.04.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cоздание задачи</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">

    <h1>Создание задачи</h1>
    <form action="<%=request.getContextPath()%>/createtask" method="post" enctype="application/x-www-form-urlencoded">
        <div class="prop-cover">
            <div class="prop-name"><p>Проект</p></div>
            <div class="prop-desc">
                <%String projectId = request.getParameter("pid");%>
                <c:set var="projectId" value="<%=projectId%>" scope="page"/>
                <%List<Project> projectList = (List<Project>) request.getAttribute("projects");%>
                <select  name="pid">
                    <c:forEach var="project" items="<%=projectList%>">
                        <option value="${project.id}"  ${project.id.equals(projectId) ? 'selected="selected"' : ''} >${project.name}</option>
                    </c:forEach>
                </select></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Название</p></div>
            <div class="prop-desc">
                <input type="text" name="name" value="" placeholder="Название задачи"/></div>
        </div>
        <div class="prop-cover">
            <div class="prop-name"><p>Описание</p></div>
            <div class="prop-desc"><textarea rows="3" name="desc" placeholder="Описание задачи"></textarea>
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
        <div class="but-cover margin_10">
            <button type="submit">Отправить</button>
        </div>
    </form>


</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
