<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>会員情報更新</p>
<p>ID検索</p>
<c:if test="${existence != null }">${existence}</c:if>
<c:remove var="existence"/>
<c:if test="${errormsg != null }">${errormsg}</c:if>
<c:remove var="errormsg"/>
<input type="submit" value="更新" >
<input type="reset" value="リセット" name="rest">
<input type="submit" onclick="location.href='/MemberInformation/views/ALLpage.jsp'">戻る</button>
</form>

</body>
</html>