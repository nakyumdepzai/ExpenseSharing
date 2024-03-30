<%-- 
    Document   : search
    Created on : Dec 30, 2023, 3:43:25 PM
    Author     : nakyumdepzaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Sharing</title>
    </head>
    <body>
        <div id="header">
            <%@ include file="header.jsp"%>
        </div>
        <h1>Search</h1>
        <form action="searchAction">
            Search Value <input type="text" name="searchValue" value=""/> </br>
            <input type="submit" value="Search"/>
        </form>

        <c:set var="searchValue" value="${param.searchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>
            <c:if test="${not empty result}">
                <table>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result}" var="dto" varStatus="counter">
                        <form action="searchAction" method="POST">
                            <tr>
                                <td>${counter.count}.</td>
                                <td>${dto.ID}</td>
                                <td>${dto.username}</td>
                                <td>${dto.role}</td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
        <div id="footer">
            <%@include file="footer.jsp" %>
        </div>
</body>
</html>
