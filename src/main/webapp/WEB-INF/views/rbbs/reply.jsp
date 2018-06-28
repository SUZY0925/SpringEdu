<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>댓글</title>
<style>
.textByte {
	display: inline;
}

#modifyDiv {
	/* width: 300px;
	height: 200px;
	background-color: gray;
	top: 20%;
	left: 37%;
	padding: 20px;
	z-index: 10; */
	
}

/* #rereDiv {
	width: 300px;
	height: 200px;
	background-color: gray;
	top: 40%;
	left: 37%;
	padding: 20px;
	z-index: 10;
}
 */
#pageNumList {
	list-style: none;
	display: inline;
	padding: 5px;
	padding-left: :20px;
}

#modifyBtn {
	margin-left: 5px;
}

.reList {
	margin-bottom: 20px;
	list-style: none;
}

#goodBtn {
	margin-left: 5px;
}

#replyContent {
	margin-top: 5px;
}

#allDiv {
	width: 100%;
	padding-right: 50px;
	padding-left: 50px;
	margin-right: auto;
	margin-left: auto;
}
#pageNumList>li{
      list-style:none;
      display:inline;
   }

</style>
<script>
	/* var bNum = ${bbsdto.bNum}; */
	var bNum = ${view.bnum};
	var reReqPage = 1;
	
	// 글자수 제한 두기
	$(document).ready(function() {
	    	$('#allDiv textarea').on('keyup focus', function() {
	    	var limitbyte = 197;
	    	var str = $(this).val();
	    	var strPiece = "";
	    	var strLength = 0;
	    	for(var i = 0; i<str.length; i++) {
	    		if(strLength > limitbyte) {
	    			break;
	    		}
	    		var code = str.charCodeAt(i);
	    		var ch = str.substr(i,1).toUpperCase();
	    		
	    		strPiece += str.substr(i,1);
	    		code = parseInt(code);
	    		if ((ch < "0" || ch > "9") && (ch < "A" || ch > "Z") && ((code > 255) || (code < 0)))
	    		{
                    strLength += 3; //UTF-8 3byte 로 계산
                }else{
                    strLength += 1;
                }
	    	}
	    	$(".textByte").html(strLength+"/200");
	    	$(this).val(strPiece);
	    });
	    
	});


	$(function() {
		var login_id = "${user.username}";
		var login_name = "${user.name}";
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
		
		//$("#modifyDiv").hide();// 댓글수정양식 숨기기
		//$("#rereDiv").hide();// 대댓글 양식 숨기기
		
		// 댓글수정 대댓글 양식 숨기기
		formhide();
		
		// 댓글목록 가져오기 호출
		replyList(reReqPage);
		
		// 댓글 목록 처리
		$("#reply").on("click", ".reList #modifyBtn", function() {
			$("#rereDiv").hide();
			$("#writeReply").hide();
			
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");
			
			// 댓글내용 분리 작업.. 
			var strArray = li.text().split("|");
			var reContent = strArray[1].substring(24); // 날짜랑 분리,,

			$(".title-diaLog").html(rNum);
			$("#reContent").val(reContent);
			$("#modifyDiv").show();
		});

		// 댓글 수정창 닫기
		$("#exitBtn").click(function() {
			formhide();
			$("#writeReply").show();
			formclear();
		});
		
		//대댓글 작성창 닫기
		$("#reExitBtn").click(function() {
			formhide();
			$("#writeReply").show();
			formclear();
		});


		// 댓글 삭제하기
		$("#reDelBtn").click(function() {
			var rNum = $(".title-diaLog").html();
			console.log(rNum);
			$.ajax({
				type : "DELETE",
				url : "/rbbs/delete/"+rNum,
				dataType : "text",
				success : function(result) {
					replyList(reReqPage);
					formhide();
					$("#writeReply").show();
					formclear();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});
		
		// 댓글 수정하기
		$("#reModifyBtn").on("click", function() {
			var rNum = $(".title-diaLog").html();
			var rContent = $("#reContent").val();
			$.ajax({
				type : "PUT",
				url : "/rbbs/modify",
				dataType : "text",
				data : JSON.stringify({
					rid : login_id,
					rnum : rNum,
					rcontent : rContent
				}),
				contentType:'application/json; charset=utf-8',
				success : function(result) {
					replyList(reReqPage);
					formhide();
					$("#writeReply").show();
					formclear();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});


		});

		// 댓글 작성하기
		$("#replyBtn").click(function() {
			var replyContent = $("#replyContent").val();

			if ($("#replyContent").val() == "") {
				alert("내용을 입력해주세요!");
				$("#replyContent").focus();
				return false;
			}

			$.ajax({
				type : "POST",
				url : "/rbbs/write",
				dataType : "text",
				data : JSON.stringify({
					rid : login_id,
					bnum : bNum,
					rname : login_name,
					rcontent : replyContent
				}),
				contentType:'application/json; charset=utf-8',
				success : function(result) {
					formhide();
					alert("댓글 작성 성공~");
					replyList(reReqPage);
					$("#writeReply").show();
					formclear();		
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		}); 


		// '댓글' 버튼을 클릭했을때
		$("#reply").on("click", ".reList #reReplyBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");
			
			$("#writeReply").hide();
			$("#modifyDiv").hide();
			$("#rereDiv").show();
			$(".title-diaLog").html(rNum);

			// 댓글 작성하기를 클릭했을때
			$("#rereplyBtn").click(function() {
				
				var reReplyContent = $("#reReplyContent").val();

				if ($("#reReplyContent").val() == "") {
					alert("내용을 입력해주세요!");
					$("#reReplyContent").focus();
					return false;
				}
				
				$.ajax({
					type : "POST",
					url : "/rbbs/reply",
					dataType : "text",
					async:false,
					data : JSON.stringify({
						rid : login_id,
						rnum : rNum,
						rname : login_name,
						rcontent : reReplyContent
					}),
					contentType:'application/json; charset=utf-8',
					success : function(result) {
						formhide();
						alert("댓글 작성 성공~");
						replyList(reReqPage);
						$("#writeReply").show();
						formclear();
					},
					error : function(e) {
						console.log("실패" + e);
					}
				});
			});
		});

		// 좋아요 버튼 클릭
		$("#reply").on("click", ".reList #goodBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");

			$.ajax({
				type : "PUT",
				url : "/rbbs/good/"+rNum,
				dataType : "text",
				success : function(result) {
					replyList(reReqPage);
					formhide();
					alert("좋아요");
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});

		// 싫어요 버튼 클릭
		$("#reply").on("click", ".reList #badBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");

			$.ajax({
				type : "PUT",
				url : "/rbbs/bad/"+rNum,
				dataType : "text",
				success : function(result) {
					replyList(reReqPage);
					formhide();
					alert("싫어요");
					
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});
		
		// 페이지 선택했을 때
		$("#pageNumList").on("click", "a ", function(evt) {
			evt.preventDefault();
			reReqPage = $(this).attr("href");
			replyList(reReqPage);
			formhide();
			formclear();
		});
	});


	// 댓글 목록 가져오기	
	function replyList(reReqPage) {
		var str = "";
		var findWriter = "";
		$.ajax({
			type : "GET",
			url : "/rbbs/map/" + bNum + "/" + reReqPage,
			dataType : "JSON",
			success : function(data) {
				$.each(data.rec, function() {
					 var date = new Date(this.rcdate);
					 
					 if(this.rindent==0 ) {
						str+="<hr>";
					}
					
					str += "<li data-rNum='" + this.rnum + "' class = 'reList'>";
					if(this.rindent>0) {
						for(var i = 0; i < this.rindent; i ++) {
							str += "&nbsp&nbsp&nbsp";
						}
						str+= "<i class=\"material-icons\" style = \"font-size:15px;\">" + "&#xe5da;"+ "</i>";
					}
					str += "<b>" + this.rname + "</b>"+ " | " + date.toLocaleString('ko-KR') +"<br>";

					if(this.rindent>0) {
							for(var i = 0; i < this.rindent; i ++) {
								str += "&nbsp&nbsp&nbsp";
							}
						} 
						
						str += this.rcontent + " | ";
					
						if(this.rid == "${user.username}") {
							str += "<button id=\"modifyBtn\" style=\"float:right\" class='btn btn-primary btn-sm'>수정</button>";
						}
						
						str +="<button id=\"reReplyBtn\" style=\"float:right\" class='btn btn-primary btn-sm'>댓글</button>"
				        + "<a href='#' id='goodBtn'><i class='material-icons'>thumb_up</i>"
				        + this.rgood + "</a>  "
				        + "<a href='#' id='badBtn'><i class='material-icons'>thumb_down</i>"
				        + this.rbad +"</a>" 
						+ "</li>";
				});
		
				$("#reply").html(str);
			
				//페이지 리스트 호출
				showPageList(data.pageCriteria);
			},
			error : function(error) {
				console.log("실패" + error);
			}
		});
	}
	
	// 페이지 리스트
	function showPageList(pageCriteria) {
		var str = "";
		
		// 이전표시
		if(pageCriteria.prev) {
			str += "<li class='page-item'><a href='1'>◀</a></li>";
			str += "<li class='page-item'><a href='" + (pageCriteria.startPage-1) + "' aria-label=\"Prev\">" + 
			"<span aria-hidden=\"true\">&laquo;</span> <span class=\"sr-only\">Prev</span> "
			+ "</a></li>";
		
		}
		for(var i= pageCriteria.startPage, end=pageCriteria.endPage; i<=end; i++)  {
			str += "<li class=\"page-item \"><a href='" + i + "'>" + i + "</a></li>";
		}
		//다음 표시
		if(pageCriteria.next) {
			str += "<li class='page-item'><a href='" + (pageCriteria.endPage+1) + "' aria-label=\"Next\">" + 
			"<span aria-hidden=\"true\">&raquo;</span> <span class=\"sr-only\">Next</span> "
			+ "</a></li>";
			str += "<li class='page-item'><a href='" + (pageCriteria.finalEndPage) + "'>" + "▶</a></li>";			
		}
		$("#pageNumList").html(str);
	}
	
	// 폼안에 있는 내용 삭제
	function formclear() {
		$('#allDiv textarea, #allDiv input').val("");
	}
	
	// 수정, 리댓 폼 하이드
	function formhide() {
		$("#modifyDiv, #rereDiv").hide();
	}
	
</script>

</head>
<body>
	<div class="container" id="allDiv">

		<!-- 댓글 작성하기 폼 -->
		<div id="writeReply">
			<input type="text" name="" id="writer" class="form-control-m"
				placeholder="작성자" value="${user.name}" readOnly="readOnly"/><br>
			<textarea name="rContent" id="replyContent" class="form-control-m"
				cols="60" rows="3" placeholder="이곳에 댓글을 입력하세요."></textarea>
			<div class="textByte"></div>
			<button id="replyBtn" style="float: right"
				class='btn btn-primary btn-sm'>댓글작성</button>
		</div>

		<!-- 댓글의 수정버튼을 눌렀을때의 폼.. -->
		<div id="modifyDiv">
			<span class="title-diaLog"></span>번 댓글<br>
			<textarea id="reContent" cols="60" rows="3" class="form-control-m"
				placeholder="이곳에 댓글을 입력하세요."></textarea>
			<div class="textByte"></div>
			<div style="float: right">
				<button id="reModifyBtn" class='btn btn-primary btn-sm'>수정</button>
				<button id="reDelBtn" class='btn btn-primary btn-sm'>삭제</button>
				<button id="exitBtn" class='btn btn-primary btn-sm'>닫기</button>
			</div>
		</div>

		<!-- 대댓글 작성할때의 폼.. -->
		<div id="rereDiv">
			<span class="title-diaLog"></span>번 댓글에 댓글달기<br> <input
				type="text" name="" id="reWriter" value="${user.name}" readOnly="readOnly" class="form-control-m" /><br>
			<textarea name="rContent" id="reReplyContent" class="form-control-m"
				cols="60" rows="3" placeholder="이곳에 댓글을 입력하세요."></textarea>
			<div class="textByte"></div>
			<div style="float: right">
				<button id="rereplyBtn" class='btn btn-primary btn-sm'>댓글작성</button>
				<button id="reExitBtn" class='btn btn-primary btn-sm'>닫기</button>
			</div>
		</div>


		<h4>댓글리스트</h4>
		<ul id="reply">

		</ul>

		<ul id="pageNumList"
			class="pagination">
		</ul>
	</div>
