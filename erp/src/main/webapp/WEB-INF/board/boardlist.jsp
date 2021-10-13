<%@page import="multi.erp.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//자바스크립트에서 컨트롤러에서 공유한 데이터를 꺼내기
	category = "${category}"; //EL표기법으로 공유한 데이터를 꺼내는 작업
	//alert(category);
	//category설정하는 작업. jqeury
	$(document).ready(function(){
		//선택한 카테고리 고정시키는 방법 (컨트롤러 들어갔다 나와도 그대로 있도록)
		$("#category").val(category).attr("selectd", "selected");
		//<select>에서 선택이 바뀔때마다 change이벤트 발생 -> change이벤트가 발생하면 /board/list.do를 호출하면서
		//category파라미터를 넘김
		$("#category").change(function(){
			location.href="/erp/board/list.do?category="+encodeURI($(this).val()) // javascrpit랑 연결부
		});
	});
</script>
</head>
<body>
	<h3>JSTL게시판</h3>
	<% ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>)request.getAttribute("boardlist"); 
		int size = boardlist.size();
	%>
	<div style="padding-top: 30px">
		<div class="col-md-3" style="padding-bottom: 10px">
		    구분:
			<form >
				<select name="category"  id="category">
					<option value="all">전체게시물</option>
					<option value="경조사">경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판</option>
				</select>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=0; i<size ; i++) {
					BoardVO board = boardlist.get(i);	
				%>
				
					<tr>
						<td><%= board.getBoard_no() %></td>
						<td><%= board.getTitle() %></td>
						<td><%= board.getId() %></td>
						<td><%= board.getWrite_date() %></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	<form action="/erp/board/search.do">
		<select name="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select> <input type="text" name="search" /> <input type="submit" value="검색">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/erp/board/insertPage.do" style="text-align: right;">글쓰기</a></li>
		</ul>
	</form>

</body>
</html>
