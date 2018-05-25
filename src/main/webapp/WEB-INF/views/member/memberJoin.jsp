<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>회원가입폼</title>
<script>

$(document).ready(function() {
	var year = "";
	for(var i = 1950; i <2019; i++) {
		year += "<option value=\"" + i + "\">" + i + "</option>"
	}
	$("#year").html(year);
	
	var month = "";
	for(var i = 1; i <13; i++) {
		month += "<option value=\"" + i + "\">" + i + "</option>"
	}
	$("#month").html(month);
	
	var day = "";
	for(var i = 1; i <32; i++) {
		day += "<option value=\"" + i + "\">" + i + "</option>"
	}
	$("#day").html(day);
	
	var birth = year+""+month+""+day;
	$("#birth").val(birth);
	
});
/* function test() {
	var arr = $("#date").val().split("-");
	var year = arr[0];
	var month = arr[1];
	var day = arr[2];
	console.log("year "+year);
	console.log("month "+month);
	console.log("day "+day);
}
 */

</script>
</head>
<body>
	<div class="container">
		<br />
		<h3>회원가입</h3>
		<hr />
		<form:form comandName="memberVO" action="/member/memberJoinOK" method="post">
		<label class="col-lg-2">아이디</label>
		<form:input type="email" path="id" id="id" placeholder="abc@abc.com" class="form-control-sm" /> <br>
		<form:input path="id" type="text" /> <form:errors path="id" type="text" />
		
		<label class="col-lg-2">비밀번호</label>
		<form:input type="password" path="passwd" id="passwd" class="form-control-sm" /> <br>
		<form:input path="passwd" type="text" /> <form:errors path="passwd" type="text" />
		
		<label class="col-lg-2">비밀번호확인</label>
		<form:input type="password" path="passwd" id="passwd_chk" class="form-control-sm" /> <br>
		<form:input path="passwd" type="text" /> <form:errors path="passwd" type="text" />
		
		<label class="col-lg-2">이름</label>
		<form:input type="text"  path="name" id="name" class="form-control-sm" /> <br>
		<form:input path="name" type="text" /> <form:errors path="name" type="text" />
		
		<label class="col-lg-2">생년월일 </label>
		<!-- <input type="date" value="2018-01-01" id="date" name="date" /> <br> -->
		<select name="year" id="year" class="form-control-sm"></select>년
		<select name="month" id="month" class="form-control-sm"></select>월
		<select	name="day" id="day" class="form-control-sm"></select>일 <br>
		<form:input type="hidden" id="birth" path="birth"/>
		<form:input path="birth" type="text" /> <form:errors path="birth" type="text" />		
		
		<label class="col-lg-2">전화번호</label>
		<form:input type="text" path="phone" id="phone" class="form-control-sm" /> <br> <br>
		<form:input path="phone" type="text" /> <form:errors path="phone" type="text" />
		
		<input type="submit" value="회원가입" id="memJoin" class="btn btn-outline-primary btn-sm">
		<input type="button" value="돌아가기" id="memJoin" class="btn btn-outline-dark btn-sm" onClick="javascript:location.href='/'" />
		</form:form>
	</div>
</body>
</html>