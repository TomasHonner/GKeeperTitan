<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<m<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="css/mainstyle.css" />" rel="stylesheet" />
        <title><spring:message code="index.title" /></title> 
</head>
 
 
<body>
    <div id="page-wrap">
    <h2><spring:message code="index.welcome" /></h2>
        <div class="user">
           <spring:message code="user.name"/>&nbsp;
           ${userSession}<br>
           <a href="<c:url value="/login"/>">Login</a>
           <br>
           <a href="<c:url value="/logout"/>">Logout</a>
       </div>
    <a href="<c:url value="/animals"/>">List of animals</a><br>
    <a href="<c:url value="/users"/>">Administration</a><br>
    </div>
</body>
</html>