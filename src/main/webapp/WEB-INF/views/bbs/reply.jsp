<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="true" />

<title>Insert title here</title>
</head>

<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />

<div class="container">
<p class="h2" align="center">답글작성</p>
<form action="/bbs/reply" method="post">
<table class="table">
	<input type="hidden" name="bnum" value="${replyView.bnum }"/>
	<input type="hidden" name="bgroup" value="${replyView.bgroup }" />
	<input type="hidden" name="bstep" value="${replyView.bstep }" />
	<input type="hidden" name="bindent" value="${replyView.bindent }" />
	<input type="hidden" name="reqPage" value="${reqPage }" />
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" name="btitle" class="form-control" value="re : ${replyView.btitle }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">작성자</th>
			<td scope="col">
				<input type="text" name="bname" class="form-control" value="${replyView.bname }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">조회수</th>
			<td scope="col"> 
				<input type="text" name="bhit" readonly="readonly" class="form-control" value="${replyView.bhit }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">수정일</th>
			<td scope="col"> 
				<input type="text" name="budate" readonly="readonly" class="form-control" value="${replyView.budate }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">내용</th>
			<td scope="col">
				<textarea name="bcontent" class="form-control" rows="5">${replyView.bcontent }
-------------------------------
</textarea>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="right">
			<input class="btn btn-secondary" type="submit"  value="답글등록">
			<a href="list" class="btn btn-secondary" role="button" aria-pressed="true" >목록으로</a>
			</td>
		</tr>
</table>
</form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="true" />