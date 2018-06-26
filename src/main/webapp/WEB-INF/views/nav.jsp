<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication property="principal" var="user" scope="session"/>
<script>
$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});
</script>
<body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.0/js/mdb.min.js"></script>

<div class="container">

<header id="header">
<div class="py-1 text-center filter-dark">
	<div class="row">
		<div class="col-md-12"> 
			<h1 class="display-3">SPRING FRAMEWORK</h1>
		</div>
	</div>
</div>
</header>
</div>

    <div class="container">
	<nav id="nav" class="navbar navbar-expand-lg navbar-dark danger-color" style="margin-bottom:5%;"> 
    <a class="navbar-brand" href="/">SuzyBar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="basicExampleNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            
	            <li class="nav-item">
	            <sec:authorize access="isAnonymous()">
					<a class="nav-link" href="${pageContext.request.contextPath}/login/login">Log in</a>
				</sec:authorize>
	            </li>
	        
		        <li class="nav-item">
		         <sec:authorize access="isAuthenticated()">
					<a class="nav-link" href="${pageContext.request.contextPath}/login/logout">Log out</a>
				</sec:authorize>
		        </li>
            
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/admin/memberList">Member List</a>
                    <a class="dropdown-item" href="/admin/admin">관리자페이지</a>
                </div>
             </li>
            </sec:authorize>  
                
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bbs/list">bbs</a>
            </li>

        </ul>
        <form class="form-inline">
            <div class="md-form my-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            </div>
        </form>
    </div>
</nav>
</div>