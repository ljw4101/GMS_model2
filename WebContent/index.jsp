<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"name="viewport" content="width=device-width, initial-scale=1.0">
<title>member detail</title>	
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body><div id="wrapper">
	<header>
		<h1 id="title">학생관리</h1>
		<div id="now_time">현재시간: <%= new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss").format(new Date()) %></div><br />
		<a id="go_main" href="<%=request.getContextPath()%>/WEB-INF/common/main.jsp">메인으로 가기</a><br />
	</header>
	<hr />

	<div id=loginImg>
		<img src="<%=request.getContextPath() %>/resources/img/login.gif" alt="" />
	</div>
	<form id="login" action="<%=request.getContextPath() %>/common.do?" method=get> <!-- 1. CommonController 호출 -->
		<span>ID: </span><input type="text"  name="id" value="kang" /><br /><mark>ID는 숫자포함 8자이내</mark><br />
		<label for="">Password: </label><input type="password" name="pw" value="1" /><br />
		
		<input type="submit" value="LOGIN" />
		<input type="reset" value="CANCEL"/>
		<input type="hidden" name="action" value="login"/>
		<input type="hidden" name="page" value="main"/>
	</form>
	
<hr />
	<footer>
		<div>
			<p>Posted by: Hanbit</p>
		  	<p>Contact information: <a href="mailto:someone@example.com">someone@hanbit.com</a>.</p>
		  	<a href="util/jdbc_test.jsp">DB연결 테스트</a>
		  	<a href="util/update_email.jsp">email Update</a>
		</div>
	</footer>
</div>
</body>
</html>