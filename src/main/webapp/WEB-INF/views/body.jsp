<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<section id="content">
<c:if test="${login.id != null}" >
${login.id}님 환영합니다. <br />
</c:if>
<c:if test="${login.id == null}" >
로그인을 해주세요.
</c:if>
</section>
</div>