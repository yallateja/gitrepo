<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${sessionScope.username == 'admin'}">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.username != 'admin'}">
<jsp:include page="header.jsp"></jsp:include>
</c:if>

<table class="table table-bordered table-striped table-hover">
<thead>
<tr>

<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Remarks</th>
<th>User Logged In</th>
</tr>
</thead>

<tbody>

<c:forEach items="${userList.contactList}" var="contact">

<tr>
<td>${contact.name}</td><td>${contact.email}</td><td>${contact.phone}</td><td>${contact.remarks}</td><td>${userList.loginName}</td>

</tr>
</c:forEach>




</tbody>

</table>