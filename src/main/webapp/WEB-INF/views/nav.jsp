<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <c:if test="${login == null}" >
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login/logIN">Log in</a>
            </li>
            </c:if>
            <c:if test="${login != null}">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login/logOut">Log out</a>
            </li>
            </c:if>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/member/memberList">Member List</a>
                </div>
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