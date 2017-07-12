<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery ScrollPagination</title>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/scrollpagination.js"></script>

<link href="style.css" rel="stylesheet" media="screen" />

<script type="text/javascript">
$(function(){
	$('#content').scrollPagination({
		'contentPage': 'democontent.html', // 结果你抓取的url
		'contentData': {}, // 这些变量可以通过请求,例如:children().size()你知道哪个页面
		'scrollTarget': $(window), // 谁会滚动?在这个例子中,完整的窗口
		'heightOffset': 10, // 它将请求当滚动页面结束前10像素
		'beforeLoad': function(){ // 加载函数之前,您可以显示预紧器div
			$('#loading').fadeIn();	
		},
		'afterLoad': function(elementsLoaded){ // 加载内容之后,您可以使用这个函数来激活你的新元素
			 $('#loading').fadeOut();
			 var i = 0;
			 $(elementsLoaded).fadeInWithDelay();
			 if ($('#content').children().size() > 100){ // 如果超过100的结果已经加载,然后停止分页(仅用于测试)
			 	$('#nomoreresults').fadeIn();
				$('#content').stopScrollPagination();
			 }
		}
	});
	
	//淡入代码元素
	$.fn.fadeInWithDelay = function(){
		var delay = 0;
		return this.each(function(){
			$(this).delay(delay).animate({opacity:1}, 200);
			delay += 100;
		});
	};
		   
});
</script>
</head>
<body>

<div id="scrollpaginationdemo">

	<ul id="content">
		<li><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc elementum elementum felis. Quisque porta turpis nec eros consectetur lacinia. Pellentesque sagittis adipiscing egestas. </p></li>
		<li><p>Aliquam dapibus tincidunt odio. Phasellus volutpat dui nec ante volutpat euismod. </p></li>
		<li><p>Phasellus vehicula turpis nec dui facilisis eget condimentum risus ullamcorper. Nunc imperdiet, tortor ultrices aliquam eleifend, nisl turpis venenatis dui, at vestibulum magna tellus in tortor. </p></li>
		<li><p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris tincidunt nisi in tortor tincidunt ut ullamcorper lectus dapibus.  </p></li>
		<li><p>Aenean interdum dui vitae purus molestie nec placerat nibh semper. Maecenas ultrices elementum dapibus. Aenean feugiat, metus in mattis mattis, justo nisi dignissim libero, ac volutpat dui nibh quis metus.</p></li>
		<li><p> Morbi eget tristique dui. Vivamus nec turpis eu nisi euismod accumsan sed in tortor. Maecenas laoreet leo ut tortor viverra facilisis.</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	    <li><p>a</p></li>
	
	
	</ul>
	
    <div class="loading" id="loading">稍等……这是加载!</div>
    <div class="loading" id="nomoreresults">对不起,没有更多的分页演示结果。</div>
	
</div>

</body>
</html>