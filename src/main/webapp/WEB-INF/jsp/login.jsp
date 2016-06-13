<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="css/mainstyle.css" />" rel="stylesheet" />
        <title>Login</title>
    </head>
    <body>
        <div id="page-wrap">
        <h2>Login</h2>
         <div class="user">
            <spring:message code="user.name"/>&nbsp;
            ${userSession}<br>
            <a href="<c:url value="/logout"/>">Logout</a>
        </div>

        <c:if test="${param.error != null}">
            <div style="color: red; font-weight: bold;">Login Failed</div>
        </c:if>
        
        <c:if test="${param.logout != null}">
            <div style="color: blue; font-weight: bold;">Logout was succesful.</div>
        </c:if>
            <table>
                <tr><td>
                    <c:url value="/login" var="loginUrl" />
                    <form action="${loginUrl}" method="post">
                            <label for="username">Username</label>
                            <input id="username" name="username" type="text" />
                </td>
                </tr>
                <tr><td>
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password" />
                    </td></tr><tr><td>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" value="Login" /></td></tr>
            </table>
        </form>
        </div>
    </body>
</html>

