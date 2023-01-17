<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.kadai1601dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		kadai1601dto account = (kadai1601dto)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	年齢：<%=account.getAge() %><br>
	性別：<%=account.getGender() %><br>
	電話番号：<%=account.getGender() %><br>
	メール：<%=account.getMail() %><br>
	パスワード：********<br>
	<a href="kadai1601RegisterExecuteServlet">OK</a><br>
	<a href="RegisterFormServlet">戻る</a>
</body>
</html>