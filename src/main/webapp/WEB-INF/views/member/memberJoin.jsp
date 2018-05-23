<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<label class="col-lg-2">아이디</label><input type="email" name="id"
			id="id" placeholder="abc@abc.com" class="form-control-sm" /> <br>
		<label class="col-lg-2">비밀번호</label><input type="password"
			name="passwd" id="passwd" class="form-control-sm" /> <br> <label
			class="col-lg-2">비밀번호확인</label><input type="password"
			name="passwd_chk" id="passwd_chk" class="form-control-sm" /> <br>
		<label class="col-lg-2">이름</label><input type="text" name="name"
			id="name" class="form-control-sm" /> <br> <label
			class="col-lg-2">생년월일 </label>
		<!-- <input type="date" value="2018-01-01" id="date" name="date" /> <br> -->
		<select name="year" id="year" class="form-control-sm">
		</select>년 <select name="month" id="month" class="form-control-sm"></select>월 <select
			name="day" id="day" class="form-control-sm">
		</select>일 <br> <label class="col-lg-2">전화번호</label><input type="text"
			name="phone" id="phone" class="form-control-sm" /> <br> <br>
		<input type="button" value="회원가입" id="memJoin"
			class="btn btn-outline-primary btn-sm"
			onClick="javascript:location.href='/'"> <input type="button"
			value="돌아가기" id="memJoin" class="btn btn-outline-dark btn-sm"
			onClick="javascript:location.href='/'" />
	</div>
</body>
</html>