<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<form action="http://localhost:8080/Login/jp.co.aforce/login" method="post">
	<p>ID<input type="text" name="id"></p>
	<p>PASS WORD<input type="password" name="pass"></p>
	<input type="submit" value="ログイン">
	<p style="color:red">${error }<p>
</form>
<%@include file="../footer.html" %>