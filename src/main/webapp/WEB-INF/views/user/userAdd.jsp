<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<script type="text/javascript" src="http://libs.useso.com/js/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/css3pie/2.0beta1/PIE_IE678.js"></script>
<![endif]-->
<link type="text/css" rel="stylesheet" href="/H-ui.admin/static/h-ui/css/H-ui.css"/>
<link type="text/css" rel="stylesheet" href="/H-ui.admin/static/h-ui.admin/css/H-ui.admin.css"/>
<!--[if IE 7]>
<link href="http://www.bootcss.com/p/font-awesome/assets/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>添加用户</title>
</head>
<body>
<div class="pd-20">
  <div class="Huiform">
    <form action="/user/saveUser" method="post">
      <table class="table table-bg">
        <tbody>
          <tr>
            <th width="100" class="text-r"><span class="c-red">*</span> 用户名：</th>
            <td><input type="text" style="width:200px" class="input-text" value="" placeholder="" id="username" name="username" datatype="*2-16" nullmsg="用户名不能为空"></td>
          </tr>
          <tr>
            <th width="100" class="text-r"><span class="c-red">*</span> 密碼：</th>
            <td><input type="password" style="width:200px" class="input-text" value="" placeholder="" id="password" name="password" datatype="*2-16" nullmsg="密碼不能为空"></td>
          </tr>
          <tr>
            <th class="text-r"><span class="c-red">*</span> 性别：</th>
            <td><label>
                <input name="sex" type="radio" id="six_1" value="男" checked>
                男</label>
              <label>
                <input type="radio" name="sex" value="女" id="six_0">
                女</label></td>
          </tr>
          <tr>
            <th class="text-r">學校：</th>
            <td><input type="text" style="width:300px" class="input-text" value="" placeholder="" id="school" name="school"></td>
          </tr>
          <tr>
            <th class="text-r">專業：</th>
            <td><input type="text" style="width:300px" class="input-text" value="" placeholder="" id="major" name="major"></td>
          </tr>
          <tr>
            <th></th>
            <td><button class="btn btn-success radius" type="submit"><i class="icon-ok"></i> 确定</button></td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui.admin/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
</script>
</body>
</html>