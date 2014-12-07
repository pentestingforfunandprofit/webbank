<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1><fmt:message key="index.title"/></h1>

<p><fmt:message key="index.message"/></p>

<h2>Latest news</h2>
<ul>
<c:forEach var="press_release" items="${press_releases}">
	<li>${press_release.releaseText}</li>
</c:forEach>
</ul>

<c:if test="${param.msg != null}">
    <spring:eval expression="${param.msg}" />
</c:if>
