<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="true" />
<script>
$(function() {
	$("input[value='검색']").click(function() {
		  if ($("input[name=search]").val() == "") {
			window.alert("검색할 단어를 입력해주세요!");
			$("input[name=search]").focus();
			return false;
		}
		 location.href = "list?option=" + $("[name=option]").val() +"&search="+$("[name=search]").val() ;  
 	
		self.location = "list?reqPage=1"
		+"&option="+$("[name=option]").val()+"&search="+$("[name=search]").val();
	});	
});
</script>
<title>Insert title here</title>
</head>

<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />

	<div class="container">
		<p class="h3" align="center">글목록</p>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col" width="60%">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="dto">
					<!--여기의 list는 BbsListCmd의 setAttribute에서 저장한 alist -->
					<tr>
						<th scope="row">${dto.bnum }</th>
						<td><c:forEach begin="1" end="${dto.bindent }">　</c:forEach>
						<c:if test="${dto.bindent >0}">└</c:if> <a class="text-dark"
							href="view?bnum=${dto.bnum }&${page.getmakeURL(page.recordCriteria.reqPage) }">${dto.btitle }</a></td>
						<td>${dto.bname }</td>
						<td>${dto.bcdate }</td>
						<td>${dto.bhit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		 <table width="100%">
			<tr>
				<td width="90%">
					<ul id="pageing"
						class="pagination pagination-sm justify-content-center">
						<c:if test="${page.prev }">
							<li class="page-item"><a class="page-link"
								href="list?page.finalEndPage">◀</a></li>
							<li class="page-item"><a class="page-link"
								href="list?${page.getmakeURL(page.startPage-1) }" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
							</a></li>
						</c:if>

						<c:forEach begin="${page.startPage }" end="${page.endPage }"
							var="PAGE">
							<c:if test="${page.recordCriteria.reqPage == PAGE }">
								<li class="page-item"><a class="page-link" href="javascript:void(0)">${PAGE }</a></li>
							</c:if>
							<c:if test="${page.recordCriteria.reqPage != PAGE }">
								<li class="page-item"><a class="page-link"
									href="list?${page.getmakeURL(PAGE) }">${PAGE }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${page.next }">
							<li class="page-item"><a class="page-link"
								href="list?${page.getmakeURL(page.endPage+1) }" aria-label="Next">
									<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
							</a></li>
							<li class="page-item"><a class="page-link"
								href="list?${page.getmakeURL(page.finalEndPage) }">▶</a></li>
						</c:if>
					</ul>
				</td>
				<td> 
				<a href="/bbs/write">글쓰기</a>
				 </td>
			 </tr>
			<tr >
				<td >
					<select name="option" class="form-control-sm">
						<option <c:out value="${option == '제목 내용' ? 'selected' : ''}" />>제목+내용</option>
						<option <c:out value="${option == '작성자' ? 'selected' : ''}" />>작성자</option>
						<option <c:out value="${option == '제목' ? 'selected' : ''}" />>제목</option>
						<option <c:out value="${option == '내용' ? 'selected' : ''}" />>내용</option>
					</select>
				<input type="text" name="search" id="" class="form-control-sm" value="${search }"/>
				<input type="button" class="btn btn-dark btn-sm" id="searchBtn" value="검색" />
				</td>
			</tr>
		</table> 
	</div>
	
<jsp:include page="/WEB-INF/views/footer.jsp" flush="true" />
