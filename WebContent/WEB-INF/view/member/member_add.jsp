<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/common_head.jsp" />
	<div id=join_container class="margin-auto">
		<form id="join_form" onsubmit="memberAdd()" class="with-100pro"> <!-- post 방식  -->
		<fieldset>
		<legend>Personal information:</legend>
		<span>ID: </span>
		<input id="id" name="id" type="text" placeholder="아이디"/><br />
		<label for="">Password: </label>
		<input id="pw" name="pw" type="password" placeholder="비밀번호"/><br />	
		<span>NAME: </span>
		<input id="name" name="name" type="text" placeholder="이름"/><br />		
		<span>BirthDay: </span> 
		<input id="birth" name="birth" type="date" value="2000-05-05"/><br />
		<span>Gender: </span> 
		<input type="radio" name="gender" value="male" checked> Male
		<input type="radio" name="gender" value="female"> Female <br />
		<span>E-mail: </span> 
		<input name="email" type="email" value="leegd@test.com" style="width: 168px"/><br />
		<span>Phone: </span> 
		<input name="phone" type="text" value="010-1234-5678" style="width: 168px"/><br />
		
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
		
		<input type="hidden" name="action" value="insert"> 
		<input type="hidden" name="page" value="main"> 
		</fieldset><br />
		<input id="join_yes_btn" type="submit" value="등록" class="gms-background-blue join-button" />
		<input id="join_no_btn" type="reset" value="취소" class="gms-background-red join-button" />
		</form>
	</div>
	<script>
		function memberAdd(){
			var mem_id = document.getElementById('id').value;
			var mem_pw = document.getElementById("pw").value;
			var mem_name = document.getElementById("name").value;
			var mem_birth = document.getElementById("birth").value;
			
			if(mem_id === ""){
				alert('ID를 입력해 주세요');
				return false;
			}
			if(mem_pw === ""){
				alert('PASSWORD를 입력해 주세요');
				return false;
			}
			if(mem_name === ""){
				alert('NAME를 입력해 주세요');
				return false;
			}
			if(mem_birth === ""){
				alert('BIRTH를 입력해 주세요');
				return false;
			}
			
			var form = document.getElementById("join_form");
			form.action = "${ctx}/member.do?";
			form.method = "post";
			form.submit();
			return true;
		}
	</script>
<jsp:include page="../common/footer.jsp" />