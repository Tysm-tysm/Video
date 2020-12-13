<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=" utf-8">
<title>教育技术問卷調查</title>
<style type="text/css">
#q {
	width: 100%;
	height: 100px;
	background: #ccc;
	text-align: center;
	line-height: 105px;
	display: block;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: aliceblue;
	font-size: 30px;
}

.q1 {
	width: 100%;
	display: block;
	margin-top: 50px;
}

.q2 {
	width: 100%;
	display: none;
	margin-top: 50px;
}

.q3 {
	width: 100%;
	height: 130px;
	margin-left: 28%;
	font-size: 20px;
}

.ch {
	font-size: 15px;
	line-height: 15px;
}

.ra {
	height: 20px;
	width: 20px;
	background-color: rgb(255, 255, 255);
}

.button {
	margin-top: 48px;
	display: inline-block;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	*display: inline;
	vertical-align: baseline;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
}

.button1 {
	margin-top: 48px;
	display: none;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	*display: inline;
	vertical-align: baseline;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
}

.button:hover {
	text-decoration: none;
}

.button:active {
	position: relative;
	top: 1px;
}

.postion {
	margin-left: 43%;
}

.white {
	color: #606060;
	border: solid 1px #b7b7b7;
	background: #fff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#ededed));
	background: -moz-linear-gradient(top, #fff, #ededed);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#ededed');
}

.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#dcdcdc));
	background: -moz-linear-gradient(top, #fff, #dcdcdc);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#dcdcdc');
}

.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
		to(#fff));
	background: -moz-linear-gradient(top, #ededed, #fff);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed',
		endColorstr='#ffffff');
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function option(ele, flag, i, k, btn0, btn1, btn2, btn3) {
		if (flag == 2) {
			if (k < i) {
				ele.css("display", "block");
				$(ele).siblings().css('display', 'none');
				btn1.css("display", 'inline-block');
				btn0.css("display", 'none');
				// $(ele).nextAll().css('display','none');
			} else {
				ele.css("display", "block");
				$(ele).siblings().css('display', 'none');
				btn2.css("display", 'none');
				btn3.css("display", 'inline-block');
			}
		} else if (flag == 1) {
			if (k > 0) {
				ele.css("display", "block");
				$(ele).siblings().css('display', 'none');
				btn2.css('display', 'inline-block');
				btn3.css("display", 'none');
			} else {
				ele.css("display", "block");
				$(ele).siblings().css('display', 'none');
				btn0.css("display", 'inline-block');
				btn1.css("display", 'none');
			}
		} else if (flag == 0) {
			alert("已在第一页.")
		}

	}
	$(function() {
		var ele = $('.q1'), btn1 = $('#btn1'), btn2 = $('#btn2'), btn3 = $('#btn3'), btn0 = $('#btn0');
		var i = 0, flag = 0, j = $(".q3"), k = 0;
		if (j.length % 3 != 0) { //使得i+1等于问卷页数
			i = parseInt(j.length / 3);
		} else {
			i = j.length / 3;
		}
		$('#btn2').click(function() {
			k++;
			flag = 2;
			ele = ele.next("div");
			option(ele, flag, i, k, btn0, btn1, btn2, btn3)
		})
		$('#btn1').click(function() {
			k--;
			flag = 1;
			ele = ele.prev("div");
			console.log(ele)
			option(ele, flag, i, k, btn0, btn1, btn2, btn3)
		})
		$("#btn0").click(function() {
			flag = 0;
			option(ele, flag, i, k, btn0, btn1, btn2, btn3)
		})
	})
</script>
</head>
<body>
	<div id="q">Felder—Silverman 学习风格测量表</div>
	<form action="/user/userSurvey" method="post">
		<div>
			<div class="q1">
				<div class="q3">
					1. 为了较好地理解某些事物，我首先( ) <br> <input type="radio" class="ra"
						name="question1" value="A">试试看<br> <input
						type="radio" class="ra" name="question1" value="B">深思熟虑<br>
				</div>
				<div class="q3">
					2. 我办事喜欢( ) <br> <input type="radio" class="ra"
						name="question2" value="A">讲究实际<br> <input
						type="radio" class="ra" name="question2" value="B">标新立异<br>
				</div>
				<div class="q3">
					3. 当我回想以前做过的事，我的脑海中大多会出现( ) <br> <input type="radio"
						class="ra" name="question3" value="A">一幅画面<br> <input
						type="radio" class="ra" name="question3" value="B">一些话语<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					4. 我往往会( ) <br> <input type="radio" class="ra"
						name="question4" value="A">明了事物的细节但不明其总体结构<br> <input
						type="radio" class="ra" name="question4" value="B">明了事物的总体结构但不明其细节<br>

				</div>
				<div class="q3">

					5. 在学习某些东西时, 我不禁会( ) <br> <input type="radio" class="ra"
						name="question5" value="A">谈论它<br> <input
						type="radio" class="ra" name="question5" value="B">思考它<br>

				</div>
				<div class="q3">

					6. 如何我是一名教师，我比较喜欢教( ) <br> <input type="radio" class="ra"
						name="question6" value="A">关于事实和实际情况的课程<br> <input
						type="radio" class="ra" name="question6" value="B">关于思想和理论方面的课程<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					7. 我比较偏爱的获取新信息的媒体是( ) <br> <input type="radio" class="ra"
						name="question7" value="A">图画、图解、图形及图象<br> <input
						type="radio" class="ra" name="question7" value="B">书面指导和言语信息<br>

				</div>
				<div class="q3">

					8.一旦我了解了( ) <br> <input type="radio" class="ra"
						name="question8" value="A">事物的所有部分, 我就能把握其整体<br> <input
						type="radio" class="ra" name="question8" value="B">事物的整体，我就知道其构成部分<br>

				</div>
				<div class="q3">

					9.在学习小组中遇到难题时，我通常会( )<br> <input type="radio" class="ra"
						name="question9" value="A">挺身而出，畅所欲言<br> <input
						type="radio" class="ra" name="question9" value="B">
					往后退让，倾听意见<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					10. 我发现比较容易学习的是( ) <br> <input type="radio" class="ra"
						name="question10" value="A">事实性内容<br> <input
						type="radio" class="ra" name="question10" value="B">概念性内容<br>

				</div>
				<div class="q3">

					11. 在阅读一本带有许多插图的书时，我一般会( ) <br> <input type="radio" class="ra"
						name="question11" value="A">仔细观察插图<br> <input
						type="radio" class="ra" name="question11" value="B">集中注意文字<br>

				</div>
				<div class="q3">

					12. 当我解决数学题时，我常常( ) <br> <input type="radio" class="ra"
						name="question12" value="A">思考如何一步一步求解<br> <input
						type="radio" class="ra" name="question12" value="B">先看解答，然后设法得出解题步骤<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					13. 在我修课的班级中( ) <br> <input type="radio" class="ra"
						name="question13" value="A">我通常结识许多同学<br> <input
						type="radio" class="ra" name="question13" value="B">我认识的同学寥寥无几<br>

				</div>
				<div class="q3">

					14. 在阅读非小说类作品时，我偏爱( )<br> <input type="radio" class="ra"
						name="question14" value="A">那些能告诉我新事实和教我怎么做的东 西 <br>
					<input type="radio" class="ra" name="question14" value="B">那些能启发我思考的东西<br>

				</div>
				<div class="q3">

					15. 我喜欢的教师是( ) <br> <input type="radio" class="ra"
						name="question15" value="A">在黑板上画许多图解的人<br> <input
						type="radio" class="ra" name="question15" value="B">花许多时间讲解的人<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					16. 当我在分析故事或小说时( )<br> <input type="radio" class="ra"
						name="question16" value="A">我想到各种情节并试图把他们结合起来 去构想主题 <br>
					<input type="radio" class="ra" name="question16" value="B">当我读完时只知道主题是什么，然后我得
					回头去寻找有关情节 <br>

				</div>
				<div class="q3">

					17. 当我做家庭作业时，我比较喜欢( ) <br> <input type="radio" class="ra"
						name="question17" value="A">确定性的想法<br> <input
						type="radio" class="ra" name="question17" value="B">推论性的想法<br>

				</div>
				<div class="q3">

					18. 我比较喜欢( ) <br> <input type="radio" class="ra"
						name="question18" value="A">关于事实和实际情况的课程<br> <input
						type="radio" class="ra" name="question18" value="B">关于思想和理论方面的课程<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					19. 我记得最牢是( ) <br> <input type="radio" class="ra"
						name="question19" value="A">看到的东西<br> <input
						type="radio" class="ra" name="question19" value="B">听到的东西<br>

				</div>
				<div class="q3">

					20. 我特别喜欢教师( ) <br> <input type="radio" class="ra"
						name="question20" value="A">向我条理分明地呈示材料<br> <input
						type="radio" class="ra" name="question20" value="B">先给我一个概貌，再将材料与其他论题相
					联系 <br>

				</div>
				<div class="q3">

					21. 我喜欢( ) <br> <input type="radio" class="ra"
						name="question21" value="A">在小组中学习<br> <input
						type="radio" class="ra" name="question21" value="B">独自学习<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					22. 我更喜欢被认为是( ) <br> <input type="radio" class="ra"
						name="question22" value="A">对工作细节很仔细<br> <input
						type="radio" class="ra" name="question22" value="B">对工作很有创造力<br>

				</div>
				<div class="q3">

					23. 当要我到一个新的地方去时，我喜欢( ) <br> <input type="radio" class="ra"
						name="question23" value="A">要一幅地图<br> <input
						type="radio" class="ra" name="question23" value="B">要书面指南<br>

				</div>
				<div class="q3">

					24. 我学习时( ) <br> <input type="radio" class="ra"
						name="question24" value="A">总是按部就班，我相信只要努力，终有所得<br> <input
						type="radio" class="ra" name="question24" value="B">我有时完全糊涂，然后恍然大悟<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					25. 我办事时喜欢( ) <br> <input type="radio" class="ra"
						name="question25" value="A">试试看<br> <input
						type="radio" class="ra" name="question25" value="B">想好再做<br>

				</div>
				<div class="q3">

					26. 当我阅读趣闻时, 我喜欢作者( ) <br> <input type="radio" class="ra"
						name="question26" value="A">以开门见山的方式叙述<br> <input
						type="radio" class="ra" name="question26" value="B">
					以新颖有趣的方式叙述<br>

				</div>
				<div class="q3">

					27. 当我在上课时看到一幅图, 我通常会清晰地记着( ) <br> <input type="radio"
						class="ra" name="question27" value="A">那幅图<br> <input
						type="radio" class="ra" name="question27" value="B">教师对那幅图的解说
					<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					28. 当我思考一大段信息资料时，我通常( ) <br> <input type="radio" class="ra"
						name="question28" value="A">注意细节而忽视概貌<br> <input
						type="radio" class="ra" name="question28" value="B">先了解概貌而后深入细节<br>

				</div>
				<div class="q3">

					29. 我最容易记住( ) <br> <input type="radio" class="ra"
						name="question29" value="A">我做过的事<br> <input
						type="radio" class="ra" name="questio29" value="B">我想过的许多事<br>

				</div>
				<div class="q3">

					30. 当我执行一项任务是，我喜欢( ) <br> <input type="radio" class="ra"
						name="question30" value="A">掌握一种方法<br> <input
						type="radio" class="ra" name="question30" value="B">想出多种方法<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					31. 当有人向我展示资料时，我喜欢( ) <br> <input type="radio" class="ra"
						name="question31" value="A">图表<br> <input
						type="radio" class="ra" name="question31" value="B">概括其结果的文字<br>

				</div>
				<div class="q3">

					32. 当我写文章时，我通常( ) <br> <input type="radio" class="ra"
						name="question32" value="A">先思考和着手写文章的开头，然后循序渐进<br> <input
						type="radio" class="ra" name="question32" value="B">先思考和写作文章的不同部分，然后加以整<br>

				</div>
				<div class="q3">

					33. 当我必须参加小组合作课题时，我要( ) <br> <input type="radio" class="ra"
						name="question33" value="A">大家首先“集思广益”，人人贡献主意<br> <input
						type="radio" class="ra" name="question33" value="B">各人分头思考，然后集中起来比较各种想法<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					34. 当我要赞扬他人时，我说他是( ) <br> <input type="radio" class="ra"
						name="question34" value="A">很敏感的<br> <input
						type="radio" class="ra" name="question34" value="B">想象力丰富的<br>

				</div>
				<div class="q3">

					35. 当我在聚会时与人见过面，我通常会记得( ) <br> <input type="radio" class="ra"
						name="question35" value="A">他们的模样<br> <input
						type="radio" class="ra" name="question35" value="B">他们的自我介绍<br>

				</div>
				<div class="q3">

					36. 当我学习新的科目时, 我喜欢( ) <br> <input type="radio" class="ra"
						name="question36" value="A">全力以赴，尽量学得多学得好<br> <input
						type="radio" class="ra" name="question36" value="B">试图建立该科目与其他有关科目的联系<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					37. 我通常被他人认为是( ) <br> <input type="radio" class="ra"
						name="question37" value="A">外向的<br> <input
						type="radio" class="ra" name="question37" value="B">保守的<br>

				</div>
				<div class="q3">

					38. 我喜欢的课程内容主要是( )<br> <input type="radio" class="ra"
						name="question38" value="A">具体材料（事实、数据）<br> <input
						type="radio" class="ra" name="question38" value="B">抽象材料
					(概念、理论)<br>

				</div>
				<div class="q3">

					39. 在娱乐方面，我喜欢( ) <br> <input type="radio" class="ra"
						name="question39" value="A">看电视<br> <input
						type="radio" class="ra" name="question39" value="B">看书<br>

				</div>
			</div>
			<div class="q2">
				<div class="q3">

					40. 有些教师讲课时先给出一个提纲，这种提纲对我( )<br> <input type="radio"
						class="ra" name="question40" value="A">有所帮助<br> <input
						type="radio" class="ra" name="question40" value="B">很有帮助<br>

				</div>
				<div class="q3">

					41. 我认为只给合作的群体打一个分数的想法( )<br> <input type="radio" class="ra"
						name="question41" value="A"> 吸引我<br> <input
						type="radio" class="ra" name="question41" value="B">不吸引我<br>
				</div>
				<div class="q3">

					42. 当我长时间地从事计算工作时( ) <br> <input type="radio" class="ra"
						name="question42" value="A">我喜欢重复我的步骤并仔细地检查我的工作<br> <input
						type="radio" class="ra" name="question42" value="B">我认为检查工作非常无聊，我是在逼迫自己这么干<br>
				</div>
			</div>
			<div class="q2">
				<div class="q3">

					43. 我能画下我去过的地方( ) <br> <input type="radio" class="ra"
						name="question43" value="A">很容易且相当精确<br> <input
						type="radio" class="ra" name="question43" value="B">很困难且没有许多细节<br>

				</div>
				<div class="q3">

					44. 当在小组中解决问题时，我更可能是( )<br> <input type="radio" class="ra"
						name="question44" value="A">思考解决问题的步骤<br> <input
						type="radio" class="ra" name="question44" value="B">思考可能的结果及其在更广泛的领域内的应用<br>

				</div>
			</div>
		</div>
		<input type="submit" class="button1 white" id="btn3" value="提   交" />
	</form>

	<input type="button" class="button1 white postion" id="btn0"
		value="上一页" />
	<input type="button" class="button white postion" id="btn1" value="上一页" />
	<input type="button" class="button white" id="btn2" value="下一页" />
</body>

</html>
