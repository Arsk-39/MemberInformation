<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>会員情報更新</p>
<p>ID検索</p>
<c:if test="${errormsg != null }">${errormsg}</c:if>
<c:remove var="errormsg"/><br>
<form action="/MemberInformation/views/search" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索" >
<input type="reset" value="リセット" name="rest">
<input type="submit" onclick="location.href='/MemberInformation/views/ALLpage.jsp'" value="戻る">
</form>

</body>
</html>