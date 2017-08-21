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

<script>
	function goList(){
		location.href="${ctx}/common.do?action=move&page=main";
	}
	
	function goUpdate(){
		location.href="${ctx}/member.do?action=update&page=member_detail&id="+id;
	}
</script>
<jsp:include page="../common/footer.jsp" />