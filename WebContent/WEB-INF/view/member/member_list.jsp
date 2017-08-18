<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/common_head.jsp" />
	<div id="container">
		<table id="memlist-tab">
			<tr>
				<th>No.</th>
				<th>ID</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>수강과목</th>
				<th>등록일</th>
				<th>수정/삭제</th>
			</tr>
			<!-- var="i": 객체 -->
			<c:forEach var="i" items="${requestScope.list}">
			<tr>
				<!-- StudBean과 동일해야 됨 -->
				<td>${i.num}</td>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.ssn}</td>
				<td>${i.phone}</td>
				<td>${i.email}</td>
				<td>${i.title}</td>
				<td>${i.regdate}</td>
				<td>수정/삭제</td>
			</tr>
			</c:forEach>
		</table>
		
		<nav aria-label="Page navigation" style="width:380px; margin:auto">
		  <ul id="page_form" class="pagination">
		  	<!-- Previous -->
		  	<c:if test="${requestScope.prevBlock gt 0}">
			  	<li><a href="#"><span class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span></a></li>
			    <li>
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
			
		    <!-- Body / varStatus="i": int i -->
		    <c:forEach varStatus="i" begin="${requestScope.startPage}" end="${requestScope.endPage}" step="1"> 
			    <c:choose>
			    	<c:when test="${requestScope.pageNumber eq i.index}">
			    		<li class="active"><a href="#">${i.index}</a></li>
			    	</c:when>
			    	<c:otherwise>
			    		<li><a onclick="list('member','member_list',${i.index})">${i.index}</a></li>
			    	</c:otherwise>
			    </c:choose>
		    </c:forEach>
		    
		    <!-- Next -->
		    <c:if test="${requestScope.nextBlock le requestScope.theNumberOfPages}">	    
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			    <li><a href="#"><span class="glyphicon glyphicon-fast-forward" aria-hidden="true"></span></a></li>
		 	</c:if>
		  </ul>
		</nav>
	</div>

<jsp:include page="../common/footer.jsp" />