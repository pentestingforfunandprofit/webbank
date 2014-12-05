<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="side-bar">
    <a href="<c:url value="/"/>">Home</a>

    <sec:authorize ifAllGranted="ROLE_USER">  
    <a href="<c:url value="/stockquote.html?xml=<stock><symbol>TKM</symbol></stock>"/>">Stock Quote</a>  
    <a href="<c:url value="/stockquotexsl.html?xml=<stock><symbol>TKM<%2Fsymbol><%2Fstock>&xslt=%3Cxsl%3Astylesheet%20version%3D%221.0%22%0A%20xmlns%3Axsl%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2FXSL%2FTransform%22%20%20%20%20%20%20%20%20%20%0A%20xmlns%3Art%3D%22http%3A%2F%2Fxml.apache.org%2Fxalan%2Fjava%2Fjava.lang.Runtime%22%0A%20exclude-result-prefixes%3D%22date%22%3E%0A%20%20%20%20%20%20%20%20%3Cxsl%3Aoutput%20method%3D%22text%22%2F%3E%0A%20%20%20%20%20%20%20%20%3Cxsl%3Atemplate%20match%3D%22%2F%22%3E%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%3Cxsl%3Atext%3EQuote%20requested%20for%3A%20%3C%2Fxsl%3Atext%3E%3Cblink%3E%3Cxsl%3Avalue-of%20select%3D%22stock%2Fsymbol%22%2F%3E%3C%2Fblink%3E%0A%20%20%20%20%20%20%20%20%3C%2Fxsl%3Atemplate%3E%0A%3C%2Fxsl%3Astylesheet%3E"/>">Blinking Stock Quote</a>
    <a href="<c:url value="/getfile.html?file=/interest.txt"/>">Interest Rate</a>
        <p><fmt:message key="person.form.title"/></p>
            <a href="<c:url value="/person/form.html"/>"><fmt:message key="button.create"/></a> 
            <a href="<c:url value="/person/search.html"/>"><fmt:message key="button.search"/></a>
    </sec:authorize>
</div>
