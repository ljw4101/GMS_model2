<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ include file="member_head.jsp" %>

	<div id="container">
		<table id="memlist-tab">
			<tr>
				<th>No</th>
				<th>ID</th>
				<th>SSN</th>
				<th>Name</th>
				<th>Phone</th>
				<th>E-Mail</th>
				<th>학점</th>
				<th>Major</th>
				<th>RegDate</th>
				<th>수정/삭제</th>
			</tr>
		
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="<%=request.getContextPath()%>/member/member_detail.jsp?id="></a></td>
				<td></td>
				<td></td>
				<td>A</td>
				<td></td>
				<td></td>
				<td><a href="<%=request.getContextPath()%>/member/member_update.jsp?id=">수정</a>
					<a href="<%=request.getContextPath()%>/member/service_delete.jsp?id=">삭제</a></td>
			</tr>

		</table>
	</div>
<%@ include file="../common/footer.jsp" %>