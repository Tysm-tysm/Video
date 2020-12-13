<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body >
 
<table class="layui-hide" id="test" lay-filter="test"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    <button class="layui-btn layui-btn-sm" lay-event="upload">新增项目</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="view">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
          
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  var $ = layui.$
  table.render({
    elem: '#test'
    ,url:"http://127.0.0.1:8080/upload/check"
    ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
    ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
      title: '提示'
      ,layEvent: 'LAYTABLE_TIPS'
      ,icon: 'layui-icon-tips'
    }]
    ,title: '用户数据表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'videoId', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'videoName', title:'Name', width:262, edit: 'text'}
      ,{field:'videoVoiceSpeed', title:'VoiceSpeed', width:100, edit: 'text'}
      ,{field:'videoWave', title:'Wave', width:100, edit: 'text'}
      ,{field:'videoTone', title:'Tone', width:100, edit: 'text'}
      ,{field:'videoTime', title:'Time', width:100, edit: 'text', templet: function(res){
          return '<em>'+ res.videoTime +'</em>'
      }}
      ,{field:'videoUrl', title:'Url', width:362	, edit: 'text', templet: function(res){
        return '<em>'+ res.videoUrl +'</em>'
      }}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:176}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
      case 'upload':
    	 layer.open({
    	 type: 1
    	 ,title: false //不显示标题栏
    	 ,closeBtn: false
    	 ,area: '300px;'
    	 ,shade: 0.8
    	 ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
    	 ,btn: ['取消']
    	 ,btnAlign: 'c'
    	 ,moveType: 1 //拖拽模式，0或者1
    	 ,content: '<div style=" line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><form action="/upload/video" method="post" enctype="multipart/form-data"><p><input type="file" style="margin-bottom:20px" name="fileName"/></p><p><input type="submit" style="margin-bottom:20px" class="layui-btn" value="上传视频"/></p> </form></div>'
    	 
   	});
	  break;
      //自定义头工具栏右侧图标 - 提示
      case 'LAYTABLE_TIPS':
        layer.alert('这是工具栏右侧自定义的一个图标按钮');
      break;
    };
  });
  
  //监听行工具事件
   table.on('tool(test)', function(obj){
    var data = obj.data;
    console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        console.log("123");
        $.ajax({
			url: "/upload/delete",
			type: "POST",
			data:{"videoId":data.videoId},    //这个是传给后台的值
			dataType: "json",
			success: function(data){
					layer.close(index);
					obj.update({
						videoName: value
					});
					layer.msg("修改失败", {icon: 5});
			}
		});
      });
    }
    else if(obj.event === 'view'){
    	console.log(data.videoUrl);
    	layer.open({
            type: 1,
            title: '播放视频',
            content: '<video width=320 height=240  controls="controls" autobuffer="autobuffer"  autoplay="autoplay" loop="loop"><source src="' + data.videoUrl + '" type="video/mp4"></source></video>'
        });

        }
    else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.videoName
      }, function(value, index){
    	 // console.log(value);
        obj.update({
          videoName: value,
          //videoPath:'D:/fileUpload/'+value,
          videoUrl:'http://127.0.0.1:8080/images/'+value
        });
        layer.close(index);
    	$.ajax({
			url: "/upload/update",
			type: "POST",
			data:{"videoId":data.videoId,"videoName":value},    //这个是传给后台的值
			dataType: "json",
			success: function(data){

				// if(data['status']=="success"){    //这个是从后台取回来的状态值

					layer.close(index);
					//更新前台显示的值
					obj.update({
						videoName: value
					});
					// layer.msg("修改成功", {icon: 6});
				// }else{
					layer.msg("修改失败", {icon: 5});
				// }
			}

		});
      });
    }
  });
});
</script>

</body>
</html>