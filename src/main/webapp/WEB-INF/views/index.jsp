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
<title>Insert title here</title>

<style>
#header {height:10%; background-color:#ff0000}
</style>

</head>
<body>
<header id="header"></header>
<nav id="nav"></nav>
<section id="content"></section>
<footer id="footer"></footer>
메인화면
${login.id}님 환영합니다. <br />
<a href="/login/logIN">로그인</a>
<a href="/login/logOut">로그아웃</a>
</body>
</html>