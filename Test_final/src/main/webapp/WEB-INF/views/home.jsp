<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
   
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<c:if test="${sessionScope.username == 'admin'}">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.username != 'admin'}">
<jsp:include page="header.jsp"></jsp:include>
</c:if>

</head>
<body>
<h2>Welcome ${sessionScope.username}</h2>
</body>
</html>