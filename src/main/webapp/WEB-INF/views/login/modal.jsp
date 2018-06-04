<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 <!-- Modal -->
<script>
$(function() {
	$("#findid").on("click",function(e) {
		/* location.href = "/login/findID"; */
		$("#findform").attr("action","/member/findID").submit();
	});
	$("#findpw").on("click",function(e) {
		$("#findform").attr("action","/member/findPW").submit();
	});
});
</script>
