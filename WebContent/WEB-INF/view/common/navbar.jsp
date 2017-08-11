<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a onclick="moveTo('common','main')"><span class="glyphicon glyphicon-home"></span>&nbsp;Home</a></li>
      <li class="dropdown">
      	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
      	 <span class="center">회원관리</span></a>
      	 <ul class="dropdown-menu">
      	 	<li><a onclick="moveTo('member', 'member_add')">학생 추가</a></li>
      	 	<li><a onclick="moveTo('member', 'member_list')">학생 목록</a></li>
      	 	<li><a onclick="moveTo('member', 'member_search')">학생 조회</a></li>
      	 	<li role="separator" class="divider"></li>
      	 	<li><a onclick="deleteTarget('member')">학생 삭제</a></li>
      	 </ul>	
      </li>
      <li class="dropdown">
      	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
      	 <span class="center">성적관리</span></a>
      	 <ul class="dropdown-menu">
      	 	<li><a onclick="moveTo('grade', 'grade_add')">성적 추가</a></li>
      	 	<li><a onclick="moveTo('grade', 'grade_list')">성적 목록</a></li>
      	 	<li><a onclick="moveTo('grade', 'grade_detail')">성적 조회</a></li>
      	 	<li role="separator" class="divider"></li>
      	 	<li><a onclick="deleteTarget('grade')">성적 삭제</a></li>
      	 </ul>	
      </li>
      <li class="dropdown">
      	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
      	 <span class="center">게시판관리</span></a>
      	 <ul class="dropdown-menu">
      	 	<li><a onclick="moveTo('board', 'board_write')">게시판 추가</a></li>
      	 	<li><a onclick="moveTo('board', 'board_list')">게시판 목록</a></li>
      	 	<li><a onclick="moveTo('board', 'board_detail')">게시판 조회</a></li>
      	 	<li role="separator" class="divider"></li>
      	 	<li><a onclick="deleteTarget('board')">게시판 삭제</a></li>
      	 </ul>	
      </li>
    </ul>
    <span id="com_head">${sessionScope.user.name}&nbsp;<a id="logout" onclick="logout_action()" >로그아웃</a></span>
  </div>
</nav>
<script>
	function logout_action(){
		var logout = document.getElementById("logout");
		logout.href = "${ctx}/common.do?action=logout&page=index";
		return true;	
	}
	
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