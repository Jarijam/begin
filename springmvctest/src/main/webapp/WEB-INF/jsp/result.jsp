<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>MVC실행 출력결과</h1>
		<hr>
		<h2><%= request.getAttribute("result") %></h2>
		${result}
		
	</body>
</html>