<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.username == 'admin'}">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.username != 'admin'}">
<jsp:include page="header.jsp"></jsp:include>
</c:if>

<form:form commandName="contact" class="form-horizontal">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">ContactName:</label>
		<div class="col-sm-10">
			<form:input path="name" class="form-control" />
		</div>
	</div>
<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">phone:</label>
		<div class="col-sm-10">
			<form:input path="phone" class="form-control" />
		</div>
	</div>

<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Remarks:</label>
		<div class="col-sm-10">
			<form:input path="remarks" class="form-control" />
		</div>
	</div>
	
	
	
	
	
	<div class="form-group">
		<center>
		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-lg btn-primary">
		</div>
		</center>
	</div>
</form:form>
