<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<a id="go_main" href="<%=request.getContextPath()%>/index.jsp">메인으로 가기</a><br />
	</header>
	<hr />