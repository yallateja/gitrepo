<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<jsp:include page="header.jsp"/>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<%-- <script src="<c:url value="/resources/js/contact.js"/>"></script> --%>

<form:form commandName="user" class="form-horizontal" id="myform">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">UserName:</label>
		<div class="col-sm-10">
			<form:input path="name" class="form-control" />
		</div>
	</div>
<div class="form-group">
		<label for="password" class="col-sm-2 control-label">LoginName:</label>
		<div class="col-sm-10">
			<form:input path="loginName" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control" />
		</div>
	</div>

<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Address:</label>
		<div class="col-sm-10">
			<form:input path="address" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Contact:</label>
		<div class="col-sm-10">
			<form:input path="phone" class="form-control" />
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
