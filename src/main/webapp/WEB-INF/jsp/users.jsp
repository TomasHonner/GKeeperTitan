<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="css/mainstyle.css" />" rel="stylesheet" />
        <title><spring:message code="users.title"/></title> 
</head>
 
 
<body>
    <div id="page-wrap">
    <h2><spring:message code="users.welcome"/></h2>
    <div class="user">
        <spring:message code="user.name"/>&nbsp;
        ${userSession}<br>
        <a href="<c:url value="/logout"/>">Logout</a>
    </div>
	<table>
		<tr>
                    <td><spring:message code="users.firstname"/></td>
                    <td><spring:message code="users.surname"/></td>
                    <td><spring:message code="users.login"/></td>
                    <td><spring:message code="users.password"/></td>
                    <td><spring:message code="users.enabled"/></td>
                    <td><spring:message code="users.role"/></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
                            <td>${user.firstname}</td>
                            <td>${user.surname}</td>
                            <td>${user.login}</td>
                            <td>${user.password}</td>
                            <td>${user.enabled}</td>
                            <td>${user.role.role}</td>
                            <td><a href="<c:url value="/useredit/${user.id}"/>" class="edit"/>Edit</td>
                            <td><a href="<c:url value="/userdelete/${user.id}"/>" class="delete"/>Delete</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/usernew' />"><spring:message code="users.new"/></a>
        <br><br>
        <div>
                <a href="<c:url value="/"/>">Back to homepage</a>
            </div>
    </div>
    
</body>
</html>