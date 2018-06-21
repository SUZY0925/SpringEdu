<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="true"/>
<script>
	$(function() {
		$("#modi, #del, #list").on("click",function() {
			$(location).attr('href',$(this).attr('data-url'));
		});
	});
</script>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
<div class="container">
<div class="card">
			<div class="header pt-3 grey lighten-2">
	            <div class="row d-flex justify-content-start">
	                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Member List</h3>
	            </div>
	        </div>
	        <div class="card-body mx-4 mt-4">
				<table border="1" cellpadding="5" align="center">
					<tr>
						<th>#</th>
						<th>아이디</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>전화번호</th>
						<th>성별</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${memberVOS}" var="memberVO">
					<tr>
						<td>#</td>
						<td>${memberVO.id}</td>
						<td>${memberVO.name}</td>
						<td>${memberVO.birth}</td>
						<td>${memberVO.phone}</td>
						<td>
							<c:if test="${memberVO.gender == 'M'}">남자</c:if>
							<c:if test="${memberVO.gender == 'W'}">여자</c:if>
						</td>
						<td>
						<div class="col" style="margin-bottom:3px;">
							<button type="button" id="modi" class="btn btn-outline-danger btn-block z-depth-2 btn-sm" data-url="/member/memberModify/${memberVO.id}">Modify</button>
						</div>
						</td>
						<td>
						<div class="col">
							<button type="button" id="del" class="btn btn-dark btn-block z-depth-2 btn-sm" data-url="/member/memberDelete/${memberVO.id}">Delete</button>
						</div>
						</td>
					</tr>
					</c:forEach>
					<tr>
					<td colspan="8" align="center">
						<div class="col" style="width:50%">
							<button type="button" id="list" class="btn btn-danger btn-block z-depth-2 btn-sm" data-url="/member/memberJoin">Join Us</button>
						</div>
					</td>
					</tr>	
				</table>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>