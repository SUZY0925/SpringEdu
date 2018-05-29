<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>로그인</title>
<script>
$(function(){
	$("#join").on("click",function(e){
		e.prevenDefault();
		location.href="/member/memberJoin"
	});
	
	$("#login").on("click",function(e){
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
<form:form modelAttribute="user" action="/login/memLoginOK"
			method="post">
		<br />
		<h3>로그인</h3>
		<hr />
			<label class="col-lg-2">아이디</label>
			<form:input path="id" placeholder="abc@abc.com" />
			<form:errors path="id" cssClass="errmsg" />
			<br />
			
			<label class="col-lg-2">비밀번호</label>
			<form:password path="passwd" />
			<form:errors path="passwd" cssClass="errmsg" />
			&nbsp;
			<input type="submit" value="로그인" id="login"
				class="btn btn-outline-primary btn-sm">
			<input type="button" value="회원가입" id="join"
				class="btn btn-outline-dark btn-sm">
			
</form:form>
</div>
</body>
</html>