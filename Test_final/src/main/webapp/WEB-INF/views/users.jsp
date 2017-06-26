<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<%-- <script src="<c:url value="/resources/js/contact.js"/>"></script> --%>

<c:if test="${sessionScope.username == 'admin'}">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.username != 'admin'}">
<jsp:include page="header.jsp"></jsp:include>
</c:if>
<table class="table table-bordered table-striped table-hover">
<thead>
<tr>
<th>UserId</th>
<th>UserName</th>
<th>LoginName</th>
<th>Address</th>
<th>Email</th>
<th>PhoneNumber</th>
<th>LoginStatus</th>
<th>Role</th>
</tr>
</thead>

<tbody>
<c:forEach items="${users}" var="user">
<tr>
<td><a href='<spring:url value="/users/${user.userId}"/>'>${user.userId}</td><td>${user.name}</td><td>${user.loginName}</td><td>${user.address}</td>
<td>${user.email}</td><td>${user.phone}</td><td>${user.loginStatus}&nbsp;&nbsp;<a id="block" href='<spring:url value="/statusblock/${user.userId}"/>'>Block&nbsp;&nbsp;<a id="unblock" href='<spring:url value="/statusunblock/${user.userId}"/>'>UnBlock</td><td>${user.role}</td>
</tr>
</c:forEach>

</tbody>

</table>