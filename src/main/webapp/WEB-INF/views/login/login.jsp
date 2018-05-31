<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  	 <!-- string form 태그.. -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>로그인</title>
<script>
$(function(){
	$("#joinBtn").on("click",function(e){
		location.href="/member/memberJoin"
	});
	
	$("#loginBtn").on("click",function(e){
		e.preventDefault();  
		$("form").submit();
	});
});
</script>
<style>
	.errmsg{color:red;}
	.passErr{color:red;}	
</style>
</head>
<body>

<div class="container">
<form:form modelAttribute="login" action="/login/memLoginOK" method="post">
<div class="py-5">
<div class="container">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<div class="card text-white p-5 bg-dark">
<div class="card-body">
<h1 class="mb-4">Login</h1>
<div class="form-group">
<label>Email</label>
<form:input path="id" class="form-control" placeholder="Enter email" />
<form:errors path="id" cssClass="errmsg" />	
</div>
<div class="form-group">
<label>Password</label>
<form:password path="passwd" class="form-control" placeholder="Password" />
<form:errors path="passwd" cssClass="errmsg" />
</div>
<button type="submit" class="btn btn-primary" id="loginBtn">Login</button>
<button type="button" class="btn btn-secondary" id="joinBtn">Join</button>
</div>
</div>
</div>
</div>
</div>
</div>
</form:form>
</div> 
</body>
</html>