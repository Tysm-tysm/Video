<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml"xmlns:th="http://www.thymeleaf.org"

      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <title>Hello World!</title>

</head>

<body>
<div style="text-align: center;margin-top: 50px">
    <form action="/upload/video" method="post" enctype="multipart/form-data">
        <p><input type="file" name="fileName"/></p>
        <p><input type="submit" value="上传视频"/></p>
    </form>
    <form action="chaxun" >
        <p><input type="submit" value="查询视频"/></p>
    </form>
</div>
</body>

</html>

