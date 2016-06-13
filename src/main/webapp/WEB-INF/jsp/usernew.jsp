<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="css/mainstyle.css" />" rel="stylesheet" />
        <title><spring:message code="user.new.title" /></title>
    </head>
    <body>
        <div id="page-wrap">
        <h1><spring:message code="user.new.welcome" /></h1>
         <div class="user">
            <spring:message code="user.name"/>&nbsp;
            ${userSession}<br>
            <a href="<c:url value="/logout"/>">Logout</a>
        </div>
        
        <form:form method="POST" modelAttribute="user">
            <table>
                <tr>
                    <td><label for="firstname"><spring:message code="users.firstname"/></label></td>
                    <td><form:input path="firstname" id="firstname" /></td>
                    <td><form:errors path="firstname" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="surname"><spring:message code="users.surname"/></label></td>
                    <td><form:input path="surname" id="surname" /></td>
                    <td><form:errors path="surname" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="login"><spring:message code="users.login"/></label></td>
                    <td><form:input path="login" id="login" /></td>
                    <td><form:errors path="login" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="password"><spring:message code="users.password"/></label></td>
                    <td><form:input path="password" id="password" /></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="enabled"><spring:message code="user.new.enabled"/></label></td>
                    <td><form:select path="enabled" id="enabled"><form:option value="1">True</form:option><form:option value="0">False</form:option></form:select></td>
                    <td><form:errors path="enabled" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="role"><spring:message code="users.role"/></label></td>
                    <td><form:select path="roleCode" id="role">
                            <c:forEach items="${roles}" var="rol">
                                <c:choose>
                                <c:when test="${user.role.id  == rol.id}">
                                    <option value="${rol.id}" selected="">${rol.role}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${rol.id}">${rol.role}</option>
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select></td>
                    <td><form:errors path="role" cssClass="error"/></td>
                </tr> 
            </table>
                <input type="submit" value="Create user" />
        </form:form>
        <br><br>
        <div>
                <a href="<c:url value="/users"/>">Back to Administration</a>
            </div>
        </div>
    </body>
</html>
