<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="text-align: center;margin-top: 60px">歡迎登錄學習管理系統</h1>
<c:if test="${empty currentUser.qq|| currentUser.qq eq ''}">
你需要輸入qq
</c:if>
</body>
</html>