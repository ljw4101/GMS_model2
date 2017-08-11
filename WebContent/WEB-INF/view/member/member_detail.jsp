<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/common_head.jsp" />
	
	<div id="container">
		<table id="member_detail_tab">
			<tr>
				<td colspan="2" rowspan="3"><img src="${ctx}/img/" alt="" /></td>
				<th class="detail_th">이름</th>
				<td></td>
			</tr>
			<tr>
				<th class="detail_th">ID</th>
				<td></td>
			</tr>
			<tr>
				<th class="detail_th">SSN</th>
				<td></td>
			</tr>
			<tr>
				<th class="detail_th">전화</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th class="detail_th">이메일</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th class="detail_th">전공</th>
				<td colspan="3"></td>
			</tr>
		</table><br />
		<div id="btn_div">
			<button id="list_btn" onclick="javascript:goList()" >목 록</button>
			<button id="update_btn" onclick="javascript:goUpdate()">수 정</button>
		</div>
	</div>
<% 		
	//String pw = request.getParameter("pw");
	//String name = request.getParameter("name");
	//String birth = request.getParameter("birth").substring(0, 4);
	//int age = 2017-Integer.parseInt(birth);
	//String gender = (request.getParameter("gender").equals("male"))?"남":"여";
	//String email = request.getParameter("email");
	//String major = request.getParameter("major");
%>
<script>
	function goList(){
		location.href="<%=request.getContextPath()%>/member/member_list.jsp?action=list";
	}
	
	function goUpdate(){
		location.href="<%=request.getContextPath()%>/member/member_update.jsp?id=";
	}
</script>
<jsp:include page="../common/footer.jsp" />