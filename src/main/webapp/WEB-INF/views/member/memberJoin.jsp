<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="true"/>
<script>
$(function(){
	
	$("input[name=password]").on("keyup",function(){
 		if($("input[name=password]").val() != $("input[name=passwd]").val()){
 			$(".passErr").text('비밀번호가 틀립니다.');
			$(this).focus();
		}else{
			$(".passErr").text('');
		}
	});
	
 	$("#joinBtn").on("click",function(e){
		e.preventDefault();
		$("form").submit();
		
	});
	
	$("#joinClearBtn").on("click",function(e){
		e.preventDefault();		
		  $("form").each(function(){
			    this.reset();
			  });
	});	
	
	$("#joinCancelBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/";
	});	 
	      
	});

</script>
<style>
	.errmsg{color:red;}
	.passErr{color:red;}
	.container {
		width:70%;
	}	
	#BtnDiv {
		margin:auto;
		margin-bottom: 10px;
	}
	
</style>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
	<div class="container">
	<form:form modelAttribute="memberVO" action="/member/memberJoinOK?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	    <div class="card">
	        <div class="header pt-3 grey lighten-2">
	            <div class="row d-flex justify-content-start">
	                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Sign up</h3>
	            </div>
	
	        </div>
	        <div class="card-body mx-4 mt-4">
	            <div class="md-form">
	                <form:input path="id" id="Form-email4" class="form-control"/>
	                <label for="Form-email4">Your email</label>
	                <form:errors path="id" cssClass="errmsg" />
			
	            </div>
	
	            <div class="md-form">
		            <form:password path="passwd" id="Form-pass4"  class="form-control" />
			        <label for="Form-pass4">Your password</label>
					<form:errors path="passwd" cssClass="errmsg" />
	            </div>
	            
	            <div class="md-form">
	            <input type="password" name="password" class="form-control" />
	            <label for="Form-pass4">Confirm password</label>
				<i class="passErr"></i>
				</div>
				
				<div class="md-form">
				<form:input path="name" class="form-control"/>
				<label for="Form-text4">Your Name </label>
				<form:errors path="name" cssClass="errmsg" /> 
				</div>
				
				<div class="md-form">
				<form:input path="birth" class="form-control"/>
				<label for="Form-text4">Your Birth </label>
				<form:errors path="birth" cssClass="errmsg" /> 
				</div>
				
				<div class="md-form">
				<form:input path="phone" id="phone" class="form-control" /> 
				<label for="Form-text4">Your Phone</label>
				<form:errors path="phone" type="text" />
				</div>
				
				<div class="md-form">
					Your Photo  : <input type="file" name="uploadFile" /> 
				</div>
				
				<div class="custom-control custom-radio custom-control-inline" style="margin-top:10px">
				  <input type="radio"  id="customRadioInline1" name="gender" class="custom-control-input" value="M" />
				  <label class="custom-control-label" for="customRadioInline1">Men</label>
				</div>
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio"  id="customRadioInline2" name="gender" class="custom-control-input" value="W"/>
				  <label class="custom-control-label" for="customRadioInline2">Women</label>
				</div>
				
				

				</div>
	            <div class="row" id="BtnDiv">
	                <div class="col"><button type="button" class="btn btn-danger btn-block z-depth-2" id="joinBtn">REGISTER</button></div>
	            	<div class="col"><input type="button" value="Reset" id="joinClearBtn" class="btn btn-danger btn-block z-depth-2"/></div>
					<div class="col"><input type="button" value="Back" id="joinCancelBtn" class="btn btn-danger btn-block z-depth-2"/></div>
	            </div>
	        </div>
	        </form:form> 
	    </div>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>