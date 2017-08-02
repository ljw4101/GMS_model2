<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"name="viewport" content="width=device-width, initial-scale=1.0">
<title>board delete</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css" />
</head>
<body>
<div id="wrapper">
	<header>
		<h1 id="title">게시판 관리</h1>
		<div id="now_time">시간: <%= new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss").format(new Date()) %></div> <br /> 
		<a id="go_main" href="<%=request.getContextPath()%>/index.jsp">메인으로 가기</a><br />
	</header>
	<hr />