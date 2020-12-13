<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>上传文件</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body style="margin-left: 50px;">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>常规使用：视频上传</legend>
</fieldset>
<div class="layui-upload">
<form action="/upload/video" method="post" enctype="multipart/form-data">
 <p><input type="file" style="margin-bottom:20px" name="fileName"/></p>
 <p><input type="submit" style="margin-bottom:20px" class="layui-btn" value="上传视频"/></p> 
</form>
<form action="/upload/check" >
  <p><input type="submit" class="layui-btn" value="查询视频"/></p>
</form>
</div>   
</body>
</html>
