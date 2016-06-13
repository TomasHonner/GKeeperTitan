<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="css/mainstyle.css" />" rel="stylesheet" />
        <title><spring:message code="animals.title"/></title> 
</head>
 
 
<body>
    <div id="page-wrap">
    <h2><spring:message code="animals.welcome"/></h2>	
     <div class="user">
        <spring:message code="user.name"/>&nbsp;
        ${userSession}<br>
        <a href="<c:url value="/logout"/>">Logout</a>
    </div>
	<table>
		<tr>
                    <td><spring:message code="animals.species"/></td>
                    <td><spring:message code="animals.region"/></td>
                    <td><spring:message code="animals.status"/></td>
                    <td><spring:message code="animals.identifier"/></td>
                    <td><spring:message code="animals.history"/></td>
		</tr>
		<c:forEach items="${animals}" var="animal">
			<tr>
                            <td>${animal.specie.species}</td>
                            <td>${animal.region.name}</td>
                            <td>${animal.status.status}</td>
                            <td>${animal.identifier}</td>
                            <td>${animal.history}</td>
                            <td><a href="<c:url value="/animaledit/${animal.id}"/>" class="edit"/>Edit</td>
                            <td><a href="<c:url value="/animaldelete/${animal.id}"/>" class="delete"/>Delete</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/animalnew' />"><spring:message code="animals.new"/></a>
        <br><br>
        <div>
                <a href="<c:url value="/"/>">Back to homepage</a>
            </div>
    </div>
</body>
</html>