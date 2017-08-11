<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="common_head.jsp"/>
<div class="jumbotron text-center">
	<h1>Grade Management System</h1>
</div>
<!-- BS Grid -->
<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<h3>학생관리</h3>
			<ul class="list-group">
				<li class="list-group-item"><a onclick="moveTo('member', 'member_add')" >학생정보 추가</a></li>
				<li class="list-group-item"><a onclick="moveTo('member', 'member_list')" >학생정보 목록</a></li>
				<li class="list-group-item"><a onclick="moveTo('member', 'member_search')" >학생 상세정보</a></li>
				<li class="list-group-item"><a onclick="moveTo('member', 'member_update')" >학생정보 수정</a></li>
				<li class="list-group-item"><a onclick="deleteTarget('member')" >학생정보 삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>성적관리</h3>
			<ul class="list-group">
				<li class="list-group-item"><a onclick="moveTo('grade', 'grade_add')" >성적 입력</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade', 'grade_list')" >성적 목록</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade', 'grade_detail')" >성적 목록 상세</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade', 'grade_update')" >성적 수정</a></li>
				<li class="list-group-item"><a onclick="deleteTarget('grade')" >성적 삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>게시판관리</h3>
			<ul class="list-group">
				<li class="list-group-item"><a onclick="moveTo('board', 'board_write')" >게시글 쓰기</a></li>
				<li class="list-group-item"><a onclick="moveTo('board', 'board_list')" >게시글 목록</a></li>
				<li class="list-group-item"><a onclick="moveTo('board', 'board_detail')" >게시글 상제</a></li>
				<li class="list-group-item"><a onclick="moveTo('board', 'board_update')" >게시글 수정</a></li>
				<li class="list-group-item"><a onclick="deleteTarget('board')" >게시글 삭제</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
	function moveTo(servlet, page){
		location.href='${ctx}/'+servlet+'.do?action=move&page='+page;
	}
	
	function deleteTarget(flag){
		var msg;
		
		if(flag == "member"){
			msg = "삭제할 학생 ID를 입력하세요";
		}else if(flag == "grade"){
			msg = "삭제할 성적 ID를 입력하세요";
		}else if(flag == "board"){
			msg = "삭제할 게시글 번호를 입력하세요";
		}
		
		var person = prompt(msg);
	}
</script>

<jsp:include page="../common/footer.jsp"/>