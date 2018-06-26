<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
<section id="content">
<sec:authorize access="isAnonymous()">
로그인을 해주세요
</sec:authorize>
<sec:authorize access="isAuthenticated()">
${user.username }(${user.name })님 환영합니다.
</sec:authorize>

	</section>
</div>
<div class="container fixed-bottom">
	<footer id="footer"></footer>
	<div class="bg-dark text-white">
		<div class="col-md-12 mt-3">
			<p class="text-center textwhite">@Copyright 2018 KH 정보교육원 - all
				right reserved.</p>
		</div>
	</div>
</div>