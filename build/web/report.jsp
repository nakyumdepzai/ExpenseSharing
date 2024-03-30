<%-- 
    Document   : expense
    Created on : Jan 3, 2024, 2:04:51 PM
    Author     : nakyumdepzaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Expense</title>
    </head>
    <body>
        <div id="header">
            <%@ include file="header.jsp" %>
        </div>
        <h4>Expense Report</h4>
        <hr/>
        <c:set var="reportResult" value="${requestScope.REPORT_RESULT}"/>
        <c:if test="${empty reportResult}">
            <h4>no report result</h4>
        </c:if>

        <c:if test="${not empty reportResult}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Report Name</th>
                        <th>Created Date</th>
                        <th>Created By</th>
                        <th>Report Details</th>
                        <th>Update</th>
                        <th>Delete Report</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${reportResult}" var="dto" varStatus="counter">
                    <form action="showReportAction" method="POST">
                        <tr>
                            <td>${counter.count}.</td>
                            <td>${dto.reportName}</td>
                            <td>${dto.createdDate}</td>
                            <td>${dto.personName}</td>
                            <td>Report Details</td>
                            <td>Update</td>
                            <td>Delete Report</td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <script>
        function createForm() {
            var formHTML = `
        <div class="row">
          <div class="col-md-6">
            <form ation="createExpenseAction" method="POST">
              <div class="form-group">
                Name<input type="text" value="" name=""/>
              </div>
              <div class="form-group">
                Created Date<input type="date" value="createdDate" name=""/>
              </div> 
              <div class="form-group">
                <input type="submit" value="Create" name="createAction" class="btn btn-primary" />
              </div>
            </form>
          </div>
        </div>`;
            document.getElementById('formContainer').innerHTML = formHTML;
        }
    </script>
</head>
<body>
    <button onclick="createForm()">New Expense</button>
    <div id="formContainer"></div>
    <div>
        <a>Back to List</a>
    </div>
    <div id="footer">
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
