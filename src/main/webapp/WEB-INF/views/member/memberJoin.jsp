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
<script>
$(function(){
	/* var year = "";
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
	$("#birth").val(birth); */
	
	
	
	$("input[name=password]").on("keyup",function(){
 		if($("input[name=password]").val() != $("input[name=passwd]").val()){
 			$(".passErr").text('비밀번호가 틀립니다.');
			$(this).focus();
		}else{
			$(".passErr").text('');
		}
	});
	
 	$("#joinBtn").on("click",function(e){
		e.preventDefault();
		$("form").submit();
		
	});
	
	$("#joinClearBtn").on("click",function(e){
		e.preventDefault();		
		  $("form").each(function(){
			    this.reset();
			  });
	});	
	
	$("#joinCancelBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/member/memberList";
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
		<br />
		<h3>회원가입</h3>
		<hr />
		<form:form modelAttribute="memberVO" action="/member/memberJoinOK"
			method="post">
			<label class="col-lg-2">아이디</label>
			<form:input path="id"
				placeholder="abc@abc.com" class="form-control-sm" />
			<form:errors path="id" cssClass="errmsg" />
			<br>
			

			<label class="col-lg-2">비밀번호</label>
			<form:password  path="passwd" class="form-control-sm" />
			<form:errors path="passwd" cssClass="errmsg" />
			<br>
			

			<label class="col-lg-2">비밀번호확인</label>
			<input type="password" name="password" class="form-control-sm" />
			&nbsp;<span class="passErr"></span><br>

			<label class="col-lg-2">이름</label>
			<form:input type="text" name="name" path="name" id="name"
				class="form-control-sm" />
			<form:errors path="name" cssClass="errmsg" />
			<br>

			<label class="col-lg-2">생년월일 </label>
			<!-- <select name="year" id="year" class="form-control-sm"></select>년
			<select name="month" id="month" class="form-control-sm"></select>월
			<select name="day" id="day" class="form-control-sm"></select>일 <br> -->
			<form:input id="birth" path="birth" class="form-control-sm"/>
			<form:errors path="birth" cssClass="errmsg" /> <br />
			

			<label class="col-lg-2">전화번호</label>
			<form:input type="text" path="phone" id="phone"
				class="form-control-sm" />
			<br>
			<form:errors path="phone" type="text" />

			<label class="col-lg-2">성별</label>
		남<form:radiobutton path="gender" value="M" />
		여<form:radiobutton path="gender" value="W" />
			<br />
			<br />

			<input type="submit" value="회원가입" id="joinBtn"
				class="btn btn-outline-primary btn-sm">
			<input type="button" value="초기화" id="joinClearBtn"
				class="btn btn-outline-primary btn-sm">
			<input type="button" value="돌아가기" id="joinCancelBtn"
				class="btn btn-outline-dark btn-sm"/>
		</form:form>
	</div>
</body>
</html>