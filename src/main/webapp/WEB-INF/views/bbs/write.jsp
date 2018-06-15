<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<table class="table">
			<tr>
				<th class="w-25 p-3">제목</th>
				<td scope="col"><input type="text" class="form-control"
					name="btitle" placeholder="제목을 입력하세요." /></td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td scope="col"><input type="text" class="form-control"
					name="bname" placeholder="이름을 입력하세요." /></td>
			</tr>
			<tr>
				<th scope="col">내용</th>
				<td scope="col"><textarea class="form-control" name="bcontent"
						rows="10"></textarea></td>
			</tr>
			<tr>
				<!-- 버튼 들어갈곳 -->
				<td colspan=2 align="center">
				<input class="btn btn-primary" type="submit" value="등록">
					<a href="/bbs/list" class="btn btn-secondary" role="button" aria-pressed="true">목록으로</a> <!-- frontcontroller에서 cmd를 안거치고 바로 jsp로 오기때문에 param이라는 내장객체를 이용해서 바로 request를 받을 수 있음~ el구문임ㅎ -->
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>