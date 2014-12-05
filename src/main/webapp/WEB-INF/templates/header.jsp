<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="headerTitle"><img src="<c:url value="/images/tusk_mutual.jpg"/>" width="250" style="padding-right: 10px"/><fmt:message key="site.title"/></div>

<div class="subHeader">
    <sec:authorize ifAllGranted="ROLE_USER">
        <div align="right"><a href="<c:url value="/logout"/>"><fmt:message key="button.logout"/></a></div>
    </sec:authorize>
</div>
