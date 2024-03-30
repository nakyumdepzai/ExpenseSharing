<%-- 
    Document   : shareNow
    Created on : Jan 3, 2024, 3:18:35 PM
    Author     : nakyumdepzaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Share Now</title>
        <script>
            function generateFields() {
                var numberOfPeople = document.getElementById("numberOfPeople").value;
                var container = document.getElementById("peopleFields");

                // Clear previous fields
                container.innerHTML = '';

                // Generate new input fields
                for (var i = 1; i <= numberOfPeople; i++) {
                    var personLabel = document.createElement("label");
                    personLabel.innerHTML = "Person " + i + "'s name: ";

                    var personInput = document.createElement("input");
                    personInput.setAttribute("type", "text");
                    personInput.setAttribute("name", "person" + i);
                    personInput.setAttribute("placeholder", "Enter name");

                    var amountLabel = document.createElement("label");
                    amountLabel.innerHTML = "Amount for Person " + i + ": ";

                    var amountInput = document.createElement("input");
                    amountInput.setAttribute("type", "text");
                    amountInput.setAttribute("name", "amount" + i);
                    amountInput.setAttribute("placeholder", "Enter amount");

                    container.appendChild(personLabel);
                    container.appendChild(personInput);
                    container.appendChild(amountLabel);
                    container.appendChild(amountInput);
                    container.appendChild(document.createElement("br"));
                }
            }
        </script>
    </head>
    <body>
        <div id="header">
            <%@include file="header.jsp" %>
        </div>
        <h1>Share Now</h1>
        <form action="calculateAction" method="post">
            <div class="justify-content-center">
                Nhap so nguoi: <input type="text" id="numberOfPeople" name="numberOfPeople" value=""/>
                <input type="button" value="Continue" onclick="generateFields()">
                <div id="peopleFields"></div>
                <br/>
                <input type="submit" value="Submit"/>
            </div>
        </form>
        <c:if test="${not empty pair}">
            <h2>Results:</h2>
            <ul>
                <c:forEach var="person" items="${requestScope.pair}">
                    <c:if test="${person.debt != 0}">
                        <li>${person.person1.name} tra ${person.person2.name}: ${person.debt}</li>
                        </c:if>
                    </c:forEach>
            </ul>
        </c:if>
        <div id="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
