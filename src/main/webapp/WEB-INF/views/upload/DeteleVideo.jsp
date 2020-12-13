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
<title>删除视频</title>
</head>
<body>
<div class="pd-20">
  <div class="Huiform">
    <form action="/upload/delete" method="post">
      <table class="table table-bg">
        <tbody>
          <tr>
            <th width="100" class="text-r"><span class="c-red">*</span> 视频名：</th>
            <td><input type="text" style="width:200px" class="input-text" value="" placeholder="" id="videoName" name="videoName" datatype="*2-16" nullmsg="视频名不能为空"></td>
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