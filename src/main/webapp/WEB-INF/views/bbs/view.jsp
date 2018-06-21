<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/views/header.jsp" flush="true" />

<script>
/* 	function Modify() {
		document.getElementById("viewStyle").disabled= true;
		document.getElementById("viewMode").style.display="none";
		frm_1.bTitle.readOnly = false;
		frm_1.bName.readOnly = false;
		frm_1.bContent.readOnly = false;
	} */
	$(function(){/* html문서가 다 로딩 되었을때 실행된다는 뜻.. 이 구문을 쓰지 않으면 문서가 로딩이 되지 않았을때 실행되는 경우도 있어서 잘안됨 */
		$("#viewMode").css({"display":""}); // display속성에 값을 안주게 한다는것은 보이게 한다는 뜻~
		$("#modifyMode").css({"display":"none"});
		
		// 편집모드 전환
		$("#modifyBtn").click(function(){	// 여기의 function은 이름이없는 함수
			var status = $("#modifyMode").css("display");
		if(status=="none") {
			$("#viewMode").css({"display":"none"});
			$("#modifyMode").css({"display":""});
/* 			${"#bName, #bTitle, #bContent"}.removeAttr("readonly"); */
			$("[id^='b']").removeAttr("readonly");	// id가 b로 시작하는것
		}
		});
		// 읽기모드 전환
		$("#modifyOK").click(function(){
			var status = $("#viewMode").css("display");
		if(status=="none") {
			$("#viewMode").css({"display":""});
			$("#modifyMode").css({"display":"none"});
			$("[id^='b']").attr("readonly","readonly");
		}
		
		$("#myfrm1").attr("action","/bbs/modify").submit();
		});
	});
</script>

<title>Insert title here</title>
</head>

<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />
<div class="container">
<p class="h2" align="center">글 내용보기</p>
<form name="frm_1" id="myfrm1" method="post">
<sec:csrfInput/>
<table class="table">
	<input type="hidden" name="reqPage" value="${rc.reqPage }" />
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" name="btitle" readonly="readonly" class="form-control" id="bTitle" value="${view.btitle }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">작성자</th>
			<td scope="col">
				<input type="text" name="bname" readonly="readonly" class="form-control" value="${view.bname }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">글번호</th>
			<td scope="col"> 
				<input type="text" name="bnum" readonly="readonly" class="form-control" id="" value="${view.bnum}" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">조회수</th>
			<td scope="col"> 
				<input type="text" name="bhit" readonly="readonly" class="form-control" id="" value="${view.bhit }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">수정일</th>
			<td scope="col"> 
				<input type="text" name="budate" readonly="readonly" class="form-control" id="" value="${view.budate }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">내용</th>
			<td scope="col">
				<textarea name="bcontent" readonly="readonly" class="form-control" id="bContent" rows="5">${view.bcontent }</textarea>
			</td>
		</tr>
		<tr id="viewMode">
			<td colspan=2 align="right">
			<a href="list?reqPage=${rc.reqPage }&option=${option }&search=${search }" class="btn btn-secondary" role="button" aria-pressed="true" >목록으로</a>
			<a href="reply?bnum=${view.bnum }&reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true" >답글달기</a>
			
			<%-- <a href="javascript:void(0)?reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true" id="modifyBtn">수정하기</a>
			<a href="delete?bnum=${view.bnum }&reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true">삭제하기</a> --%>
			<c:if test="${user.username eq view.bid }">
			<a href="javascript:void(0)?reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true" id="modifyBtn">수정하기</a>
			<a href="delete?bnum=${view.bnum }&reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true">삭제하기</a>
			</c:if>
			</td>
		</tr>
		<tr id="modifyMode">
			<td colspan=2 align="right">
			<input class="btn btn-secondary" type="submit" id="modifyOK" value="수정완료">
			<a href="view?bnum=${view.bnum}&reqPage=${rc.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true">취소</a>
			</td>
		</tr>
				<%-- <div style="float: right;">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="btn" href="pageNav?bnum=${view.bnum}&np=1">◀</a></li>
							<li class="page-item"><a class="btn" href="pageNav?bnum=${view.bnum}&np=0">▶</a></li>
						</ul>
					</nav>
				</div> --%>
</table>
</form>
</div>
<jsp:include page="/WEB-INF/views/rbbs/reply.jsp" />
<br />
<br />
<jsp:include page="/WEB-INF/views/footer.jsp" />