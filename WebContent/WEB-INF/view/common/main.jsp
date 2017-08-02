<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="../member/member_head.jsp" %>

	<div id="container">
	<table id="index-tab">
		<tr id="index-tab-tr">
			<th><i class="fa fa-cloud"></i> 학생관리</th>
			<th><i class="fa fa-file"></i> 성적관리</th>
			<th><i class="fa fa-bars"></i> 게시판</th>
		</tr>
		<tr>
			<td>
				<ul class="index-ul"> <!-- a Tag는 무조건 get방식 -->
					<li><a href="<%=request.getContextPath() %>/member.do?action=move&page=member_add">학생정보 추가</a></li>
					<li><a href="<%=request.getContextPath() %>/member.do?action=move&page=member_list">학생정보 목록</a></li>
					<li><a href="<%=request.getContextPath() %>/member.do?action=move&page=member_search">학생 상세정보</a></li>
					<li><a href="<%=request.getContextPath() %>/member.do?action=move&page=member_update">학생정보 수정</a></li>
					<li><a href="<%=request.getContextPath() %>/member.do?action=move&page=member_delete">학생정보 삭제</a></li>
				</ul>
			</td>
			<td>
				<ul class="index-ul">
					<li><a href="../grade/grade_add.jsp">성적 입력</a></li>
					<li><a href="../grade/grade_list.jsp">성적 목록</a></li>
					<li><a href="../grade/grade_detail.jsp">성적 목록 상세</a></li>
					<li><a href="../grade/grade_update.jsp">성적 수정</a></li>
					<li><a href="../grade/grade_delete.jsp">성적 삭제</a></li>
				</ul>
			</td>
			<td>
				<ul class="index-ul">
					<li><a href="<%=request.getContextPath()%>/board/board_write.jsp">게시글 쓰기</a></li>
					<li><a href="<%=request.getContextPath()%>/board/board_list.jsp">게시글 목록</a></li>
					<li><a href="<%=request.getContextPath()%>/board/board_detail.jsp">게시글 상제</a></li>
					<li><a href="<%=request.getContextPath()%>/board/board_update.jsp">게시글 수정</a></li>
					<li><a href="<%=request.getContextPath()%>/board/board_delete.jsp">게시글 삭제</a></li>
				</ul>
			</td>
		</tr>
	</table>
	</div>


	<%-- <script>
		alert('잘못된 비밀번호입니다.');
		location.href="<%=request.getContextPath()%>/index.jsp"
	</script>

	<script>
		alert('없는ID. 회원가입 바람니다.');
		location.href="<%=request.getContextPath()%>/member/member_add.jsp"
	</script> --%>
	
<%@ include file="footer.jsp" %>