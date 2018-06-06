<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
	request.setCharacterEncoding("utf-8");
%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="true"/>
<script>
$(function() {
	$('#htn').trigger('click');
});
</script>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
<button id="htn" data-toggle="modal" data-target="#exampleModal" hidden="true"></button>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Your Password</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <c:if test="${find.passwd eq null}">
        Not Found
       </c:if>
       <c:if test="${find.passwd ne null}">
        Your Password : ${find.passwd }
       </c:if>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">BACK</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>