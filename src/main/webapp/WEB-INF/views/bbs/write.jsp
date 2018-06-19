<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %><!-- security용 taglib, 인증 인가에 대한 access를 제어 가능 -->

<title>게시판 쓰기 양식</title>

<jsp:include page="/WEB-INF/views/header.jsp" flush="true" />
<script>
$(function() {
	$("input[value='등록']").click(function() {
		if ($("input[name=btitle]").val() == "") {
			window.alert("제목을 입력해주세요!");
			$("input[name=btitle]").focus();
			return false;
		}
		if ($("input[name=bname]").val() == "") {
			window.alert("작성자를 입력해주세요!");
			$("input[name=bname]").focus();
			return false;
		}
		if ($("textarea[name=bcontent]").val() == "") {
			window.alert("내용을 입력해주세요!");
			$("textarea[name=bcontent]").focus();
			return false;
		}
		document.write_form.submit();
	});	
});
</script>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />

<div class="container">
	<p class="h2" align="center">글쓰기</p>
	<form action="/bbs/write" method="post" name="write_form">
	<!-- security-context 설정때문에 post로 하는 일들이 모두 안먹혀서 이걸 form태그안에 작성해줌.. 아니면 spring form태그 사용. 내포되어있음 -->
	<sec:csrfInput/>
		<input type="hidden" name="bid" value="${user.username }"/>
		<table class="table">
			<tr>
				<th class="w-25 p-3">제목</th>
				<td scope="col"><input type="text" class="form-control"
					name="btitle" placeholder="제목을 입력하세요." /></td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td scope="col">
				<%-- <sec:authentication property="principal" var="user"/>  --%>
				<input type="text" class="form-control" name="bname" readOnly="readonly"
				value="${user.name }" />
				</td>
			</tr>
<!-- 			<tr>
				<th scope="col">작성자</th>
				<td scope="col"><input type="text" class="form-control"
					name="bname" placeholder="이름을 입력하세요." /></td>
			</tr> -->
			<tr>
				<th scope="col">내용</th>
				<td scope="col"><textarea class="form-control" name="bcontent"
						rows="10"></textarea></td>
			</tr>
			<tr>
				<!-- 버튼 들어갈곳 -->
				<td colspan=2 align="center">
				<input class="btn btn-primary" type="submit" value="등록">
					<a href="/bbs/list?reqPage=${param.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>