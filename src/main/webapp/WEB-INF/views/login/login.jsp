<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!-- string form 태그.. -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="true"/>
<script>
	$(function() {
		$("#joinBtn").on("click", function(e) {
			location.href = "/member/memberJoin"
		});

		$("#loginBtn").on("click", function(e) {
			e.preventDefault();
			$("#loginform").submit();
		});
		
		$("#findid").on("click",function() {
		/* 	var name = $("input[name=name]").val();
			var phone = $("input[name=phone]").val();
			$.ajax({
				type : "GET",
				url : "/member/findID",
				dataType : "text",
				data : {
					name, phone
				},
				success : function(data) {
					console.log("${find.id}");
				},
				error : function(e) {
					alert("실패" + e);
				}
			}); */ 
			$("#findform").attr("action","/member/findID").submit(); 
		});
		$("#findpw").on("click",function() {
			$("#findform").attr("action","/member/findPW").submit();
		});

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
	<div class="container">
	<form:form modelAttribute="login" action="/login/memLoginOK" method="post" id="loginform">
	<section class="form-simple">
	    <div class="card">
	        <div class="header pt-3 grey lighten-2">
	            <div class="row d-flex justify-content-start">
	                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Log in</h3>
	            </div>
	        </div>
	        <div class="card-body mx-4 mt-4">
	            <div class="md-form">
	                <form:input path="id" class="form-control" />
	                <label for="Form-email4">Your email</label>
	                <form:errors path="id" cssClass="errmsg" />
	            </div>
	            <div class="md-form pb-3">
		            <form:password path="passwd"  class="form-control" />
			        <label for="Form-pass4">Your password</label>
					<form:errors path="passwd" cssClass="errmsg" />
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
<div class="modal fade" id="exampleModalId" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Find ID</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="md-form">
	                <form:input path="name"  class="form-control" />
	                <label for="Form-email4">Name</label>
	            </div>
	    <div class="md-form">
		            <form:input path="phone"    class="form-control" />
			        <label for="Form-pass4">PhoneNumber</label>
				</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="findid">FIND</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="exampleModalPw" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Find PW</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
       <div class="modal-body">
        <div class="md-form">
	                <input type="email" name="id" class="form-control" />
	                <label for="Form-email4">Id</label>
	            </div>
	    	<div class="md-form">
		            <input type="text" name="birth"  class="form-control" />
			        <label for="Form-pass4">Birth</label>
				</div>
    	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="findpw">FIND</button>
      </div>
    </div>
  </div>
</div> 
</form:form>


</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>