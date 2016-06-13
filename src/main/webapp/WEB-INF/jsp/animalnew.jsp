<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/mainstyle.css" />" rel="stylesheet" />
        <title><spring:message code="animal.new.title"/></title>
    </head>
    <body>
        <div id="page-wrap">
        <h1><spring:message code="animal.new.welcome"/></h1>
         <div class="user">
            <spring:message code="user.name"/>&nbsp;
            ${userSession}<br>
            <a href="<c:url value="/logout"/>">Logout</a>
        </div>
        
        <form:form method="POST" modelAttribute="animal">
            <table>
                <tr>
                    <td><label for="species"><spring:message code="animals.species"/></label></td>
                    <td>
                        <form:select path="specieCode" id="specie">
                            <c:forEach items="${species}" var="tmp">
                                <c:choose>
                                <c:when test="${animal.specie.id  == tmp.id}">
                                    <option value="${tmp.id}" selected="">${tmp.species}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${tmp.id}">${tmp.species}</option>
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="specie" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="region"><spring:message code="animals.region"/></label></td>
                    <td>
                        <form:select path="regionCode" id="region">
                            <c:forEach items="${regions}" var="tmp">
                               <c:choose>
                                <c:when test="${animal.region.id  == tmp.id}">
                                    <option value="${tmp.id}" selected="">${tmp.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${tmp.id}">${tmp.name}</option>
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="region" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="status"><spring:message code="animals.status"/></label></td>
                    <td>
                        <form:select path="statusCode" id="status">
                            <c:forEach items="${statuses}" var="tmp">
                               <c:choose>
                                <c:when test="${animal.status.id  == tmp.id}">
                                    <option value="${tmp.id}" selected="">${tmp.status}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${tmp.id}">${tmp.status}</option>
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="status" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="identifier"><spring:message code="animals.identifier"/></label></td>
                    <td><form:input path="identifier" id="identifier"/></td>
                    <td><form:errors path="identifier" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="history"><spring:message code="animals.history"/></label></td>
                    <td><form:textarea path="history" id="history"/></td>
                    <td><form:errors path="history" cssClass="error"/></td>
                </tr>
            </table>
            <input type="submit" value="<spring:message code="animal.new.send" />" />
        </form:form>
            <br><br>
            <div>
                <a href="<c:url value="/animals"/>">Back to List of animals</a>
            </div>
        </div>
    </body>
</html>

