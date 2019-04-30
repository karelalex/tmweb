<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.karelin.tmweb.entity.Project" %>
<%@ page import="ru.karelin.tmweb.enumeration.Status" %><%--
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
    <% Project project = (Project) request.getAttribute("project");%>
    <c:set scope="page" var="project" value="<%=project%>"/>
    <c:if test="${project==null}">
        <h1>Проекта с указанным id не существует</h1>
    </c:if>
    <c:if test="${project!=null}">
        <h1>Описание проекта</h1>
        <form action="<%=request.getContextPath()%>/editproject" method="post" enctype="application/x-www-form-urlencoded">
            <div class="prop-cover">
                <div class="prop-name"><p>Id</p></div>
                <div class="prop-desc">${project.id}</div>
                <input value="${project.id}" type="hidden" name="pid">
            </div>
            <div class="prop-cover">
                <div class="prop-name"><p>Название</p></div>
                <div class="prop-desc">
                    <input type="text" name = "name" lass="prop-desc" value="${project.name}"/></div>
            </div>
            <div class="prop-cover">
                <div class="prop-name"><p>Описание</p></div>
                <div class="prop-desc"><textarea rows="3" name="desc">${project.description}</textarea>
                </div>
            </div>
            <div class="prop-cover">
                <div class="prop-name"><p>Дата начала</p></div>
                <div class="prop-desc"><input type="date"
                                              name = "startDate" value="<fmt:formatDate value="${project.startingDate}" pattern="yyyy-MM-dd"/>"/>
                </div>
            </div>
            <div class="prop-cover">
                <div class="prop-name"><p>Дата окончания</p></div>
                <div class="prop-desc"><input type="date" name = "finishDate"
                                              value="<fmt:formatDate value="${project.finishDate}"  pattern="yyyy-MM-dd"/>"/>
                </div>
            </div>
            <div class="prop-cover">
                <div class="prop-name"><p>Текущий статус</p></div>
                <div class="prop-desc"><select name="status">
                    <c:forEach var="stat" items="<%=Status.values()%>">
                        <option value="${stat.name()}" ${stat.name() == project.status.name() ? 'selected="selected"' : ''}>${stat.displayName}</option>
                    </c:forEach>
                </select></div>
            </div>
            <div class="but-cover margin_10">
                <button type="submit">Отправить</button>
            </div>
        </form>
    </c:if>


</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
