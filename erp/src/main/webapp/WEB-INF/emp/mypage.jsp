<%@page import="multi.erp.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% EmpVO userLogin = (EmpVO)request.getAttribute("loginOKuser"); 
		
		
	%>
	<h1>mypage</h1>
	<h3><%= userLogin.getId() %></h3>
	<!-- =================== -->
	<!-- db에서 조회한 로그인한 사용자의 별명 -->
	
</body>
</html>