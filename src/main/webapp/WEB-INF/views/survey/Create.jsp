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
<link rel="stylesheet" type="text/css" href="/H-ui.admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link type="text/css" rel="stylesheet" href="/H-ui.admin/static/h-ui.admin/css/H-ui.admin.css"/>
<!--[if IE 7]>
<link href="http://www.bootcss.com/p/font-awesome/assets/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>添加用户</title>
</head>
<body>
<div class="pd-20">
  <div class="Huiform">
    <article class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="/survey/saveSurvey" method="post">
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>问卷名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入问卷名" id="surveyTitle" name="surveyTitle">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入标题" id="Question_title" name="Question_title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2" style= "padding-right: 0px">选项：<button style="background:hsl(0, 0%, 100%);border:none"><i class="Hui-iconfont">&#xe631;</button></label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="输入选项" id="option_name1" name="option_name">
			</div>
		</div>
		<!--  <div class="row cl" id="div1">
			<label class="form-label col-xs-4 col-sm-2"style= "padding-right: 0px"><button style="background:hsl(0, 0%, 100%);border:none"><i class="Hui-iconfont">&#xe631;</button></label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="输入选项" id="option_name2" name="option_name" >
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button  class="btn btn-primary radius" onclick="adddiv()"><i class="Hui-iconfont">&#xe604;</i> 添加选项</button>	
			</div>
		</div>-->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
  </div>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui.admin/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
function adddiv(){
	 var demo=document.createElement("div");
	 demo.id=new Date().getTime();
	 demo.innerHTML=	"<div class='row cl'>"+
	    "<label class='form-label col-xs-4 col-sm-2'style= 'padding-right: 0px'><button style='background:hsl(0, 0%, 100%);border:none'><i class='Hui-iconfont'>&#xe631;</button></label>"
		+"<div class='formControls col-xs-8 col-sm-9'><input type='text' class='input-text' value='' placeholder='输入选项'  name='option_name' ></div></div>";
		document.getElementById("div1").appendChild(demo);
     }

    }
</script>
</body>
</html>