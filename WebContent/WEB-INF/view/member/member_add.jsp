<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="member_head.jsp" %>
	<div id=join_container class="margin-auto">
		<form id="join_form" action="<%=request.getContextPath()%>/member/service_add.jsp" class="with-100pro">
		<fieldset>
		<legend>Personal information:</legend>
		<span>ID: </span>
		<input name="id" type="text" placeholder="아이디"/><br />
		
		<label for="">Password: </label>
		<input name="pw" type="password" placeholder="비밀번호"/><br />
		
		<span>NAME: </span>
		<input name="name" type="text" placeholder="이름"/><br />
		
		<span>BirthDay: </span> 
		<input name="birth" type="date"/><br />
		
		<span>Gender: </span> 
		<input type="radio" name="gender" value="male" checked> Male
		<input type="radio" name="gender" value="female"> Female <br />
		
		<span>E-mail: </span> 
		<input name="email" type="email" style="width: 168px"/><br />
		
		<span>Phone: </span> 
		<input name="phone" type="text" style="width: 168px"/><br />
		
		<h3><label for="">전공</label></h3>
		<select name="major" style="height: 25px">
			<option value="computer" selected>컴퓨터공학</option>
			<option value="economics">경제학</option>
			<option value="tourism">관광학</option>
			<option value="art">미술학</option>
		</select>
		
		<h3><label for="">수강과목</label></h3>
		<input type="checkbox" name="subject" value="java" checked> 자바 <br />
  		<input type="checkbox" name="subject" value="c" checked> C언어 <br />
  		<input type="checkbox" name="subject" value="html"> HTML<br />
  		<input type="checkbox" name="subject" value="css"> CSS<br />
  		<input type="checkbox" name="subject" value="javascript"> 자바스크립트 <br />
  		<input type="checkbox" name="subject" value="sql"> SQL<br />
		
		</fieldset><br />
		<input type="submit" value="등록" class="gms-background-blue join-button" />
		<input type="reset" value="취소" class="gms-background-red join-button" />
		</form>
	</div>
<%@ include file="../common/footer.jsp" %>