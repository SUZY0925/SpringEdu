<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- string form 태그.. -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="true"/>
<script>
	$(function() {
		$("#afterID").hide();
		$("#afterPW").hide();
		
		$("#joinBtn").on("click", function(e) {
			location.href = "/member/memberJoin"
		});

		$("#loginBtn").on("click", function(e) {
			e.preventDefault();
			$("#loginform").submit();
		});
		
		$("#findid").on("click",function(e) {
		 	var name = $("input[name=name]").val();
			var phone = $("input[name=phone]").val();
			$.ajax({
				type : "GET",
				url : "/findID",
				dataType : "text",
				data : {
					name, phone
				},
				success : function(data) {
					$("#beforeID").hide();
					$("#afterID").show();
					$("#findIDstring").html(data);
				},
				error : function(e) {
					alert("조회된 아이디가 없습니다.");
				}
			}); 
		});
		
		$("#findpw").on("click",function() {
			var id = $("input[name=ids]").val();
			var birth = $("input[name=birth]").val();
			$.ajax({
				type : "GET",
				url : "/findPW",
				dataType : "text",
				data : {
					id, birth
				},
				success : function(data) {
					$("#beforePW").hide();
					$("#afterPW").show();
					$("#findPWstring").html(data);
				},
				error : function(e) {
					alert("조회된 비밀번호가 없습니다.");
				}
			}); 
		});
		
	});
	
	$(document).on('hidden.bs.modal','.modal',function(e) {
		$("#findform").each(function(){
		    this.reset();
		  });
		$("#afterID").hide();
		$("#afterPW").hide();
		$("#beforeID").show();
		$("#beforePW").show();
	});
</script>
<style>
.errmsg {
	color: red;
}
.passErr {
	color: red;
}
.container {
	width: 70%;
}
                
</style>
</head>

<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
	<c:if test="${param.fail != null}">
		로그인실패
	</c:if>
	<%-- <c:url value="j_spring_security_check" var="loginUrl" /> --%>
	<c:url value="login" var="loginUrl" />
	<div class="container">
	<form:form action="${pageContext.request.contextPath}/${loginUrl}" method="post" id="loginform">
	<section class="form-simple">
	    <div class="card">
	        <div class="header pt-3 grey lighten-2">
	            <div class="row d-flex justify-content-start">
	                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Log in</h3>
	            </div>
	        </div>
	        <div class="card-body mx-4 mt-4">
	            <div class="md-form">
	                <input type="email" name="username" class="form-control" />
	                <label for="Form-email4">Your email</label>
	                <form:errors path="username" cssClass="errmsg" />
	            </div>
	            <div class="md-form pb-3">
		            <input type="password" name="password"  class="form-control" />
			        <label for="Form-pass4">Your password</label>
					<form:errors path="password" cssClass="errmsg" />
				</div>
					<p class="font-small grey-text d-flex justify-content-end">Forgot <a href="#" data-toggle="modal" data-target="#exampleModalId" class="dark-grey-text font-weight-bold ml-1"> E-mail?</a></p>
	                <p class="font-small grey-text d-flex justify-content-end">Forgot <a href="#" data-toggle="modal" data-target="#exampleModalPw" class="dark-grey-text font-weight-bold ml-1"> Password?</a></p>
	            <div class="text-center mb-4">
	                <button type="button" class="btn btn-danger btn-block z-depth-2" id="loginBtn">Log in</button>
	            </div>
	            <p class="font-small grey-text d-flex justify-content-center">Don't have an account? <a href="#" class="dark-grey-text font-weight-bold ml-1" id="joinBtn"> Sign up</a></p>
	        </div>
	    </div>
	</section>
</form:form>        
</div>

<form:form modelAttribute="find" method="post" id="findform">
<jsp:include page="/WEB-INF/views/login/modalID.jsp" flush="true"/>
<jsp:include page="/WEB-INF/views/login/modalPW.jsp" flush="true"/>
</form:form>


</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>