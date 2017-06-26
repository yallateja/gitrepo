<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${sessionScope.user.role eq 2}">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.user.role eq 1}">
<jsp:include page="header.jsp"></jsp:include>
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


TODO COntact list

</body>
</html>