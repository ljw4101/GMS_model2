<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="member_head.jsp" %>

	<div id="container">
		<form id="detail_form" action="<%=request.getContextPath()%>/member/service_update.jsp" method="get">
		<table id="member_detail_tab">
			<tr>
				<td colspan="2" rowspan="3"><img src="<%=request.getContextPath() %>/img/" alt="" /></td>
				<th class="detail_th">이름</th>
				<td><input type="text" name="name" value=""/></td>
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
				<td colspan="3"><input type="text" name="phone" value=""/></td>
			</tr>
			<tr>
				<th class="detail_th">이메일</th>
				<td colspan="3"><input type="text" name="email" value=""/></td>
			</tr>
			<tr>
				<th class="detail_th">전공</th>
				<td colspan="3"><input type="text" name="major_id" value=""/></td>
			</tr>
		</table>
		<br />
		<div id="btn_div">
			<input type="hidden" name="id" value="" />
			<input type="submit" id="confirm_btn" value="수정"/>
			<input type="button" id="cancel_btn" onclick="javascript:cancel()" value="취소"/>
		</div>
		</form>
	</div>

<script>
	function goConfirm(){
		location.href="<%=request.getContextPath()%>/member/service_update.jsp?id=<%=request.getParameter("id")%>&name=<%=request.getParameter("name")%>";
	}
	
	function cancel(){
		location.href="<%=request.getContextPath()%>/member/member_list.jsp?action=list";
	}
</script>
<%@ include file="../common/footer.jsp" %>