<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 數據格式化 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用戶信息</title>
</head>
<body>
歡迎您${user.username }</p>
${current.sex }</p>
<fmt:formatDate value="${user.birth}" pattern="YYYY年MM月DD日"/></p>
</body>
</html>