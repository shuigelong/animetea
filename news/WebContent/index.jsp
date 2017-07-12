<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/scrollpagination.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="scrollpagination_demo.css" rel="stylesheet" media="screen" />

</head>
<script type="text/javascript">

$(function(){
	$('#content').scrollPagination({
		'contentPage': "./news", // the url you are fetching the results
		'contentData': {pagenumber:$('#content').children().size()}, // these are the variables you can pass to the request, for example: children().size() to know which page you are
		'scrollTarget': $(window), // who gonna scroll? in this example, the full window
		'heightOffset': 10, // it gonna request when scroll is 10 pixels before the page ends
		'beforeLoad': function(){ // before load function, you can display a preloader div
			$('#loading').fadeIn();	
		},
		'afterLoad': function(elementsLoaded){ // after loading content, you can use this function to animate your new elements
			 $('#loading').fadeOut();
			 var i = 0;
			 $(elementsLoaded).fadeInWithDelay();
			 if ($('#content').children().size() > 100){ // if more than 100 results already loaded, then stop pagination (only for testing)
			 	$('#nomoreresults').fadeIn();
				$('#content').stopScrollPagination();
			 }
		}
		
	});
	
	// code for fade in element by element
	$.fn.fadeInWithDelay = function(){
		var delay = 0;
		return this.each(function(){
			$(this).delay(delay).animate({opacity:1}, 200);
			delay += 100;
		});
	};
		   
});
//window.location.href="detial.jsp";
//$(document).ready(function(){
//$("#content").delegate("li","click",function(){
//$("#content").on("click","li",function(){
//	var id=$("#num").text();
//	alert(id);

	//$.ajax({  
    //    type: "post",  
    //    url: "./detial",  
     //   data: { num:id },  
    //    dataType: "json",  
    //    success: function (data) {  
	//window.location.href="detial.jsp";
   //     }
	// }); 
//});
//});
</script>
<body>
<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">animetea</a>
   </div>
   <div>
      <p class="navbar-text navbar-right">
         <a href="reg.jsp" class="navbar-link">REG</a>
         <a href="login.jsp" class="navbar-link">Login</a>
         <a href="user_manage.jsp" class="navbar-link">CENTER</a>
      </p>
   </div>
</div>
</nav>
<div id="scrollpaginationdemo">
      <div class="about">
        <h1>漫展信息</h1>
    </div>
     
    <div class="about">
    	
        <h2>主要漫展名称</h2>
        <h3>
        
 徐州：KD天坑之城同好会、DB动漫展<br />
邳州：PDE漫展<br />
上海：ComiCon、Comicup魔都同人祭、Comic Fantasia<br />
北京：Comic Present同人祭、北京原创同人交流会（ComicDive）、梦次元、赛亚coser、囧囧有神同人展、中国（北京）动漫游戏嘉年华（I DO）、M.Y.COMIC游园会、萌物语动漫兔<br />
天津：魔力游戏动漫节、漫神漫画节、滨海网络互动娱乐展览会、GC电竞动漫展、ComicJoy乐漫嘉年华<br />
杭州：杭州comic me同人展，杭州CA动漫交流展会，杭州COSPLAY文化节，杭州怀旧ONLY<br />
成都：成都同人祭（ComiDay）、Rainbow Market漫展 、iComic同人祭<br />
绵阳：SA（SevenAnima第七动漫)、BlingBlingCos同人祭、DM（DimensionMemory同人祭）、MCC(MineComic-Con)<br />
西安：西安ACME动漫游戏展、逃跑计划动漫游戏展、西安动漫游戏文化节、西安Glitz Dream同人交流会<br />
武汉：江城同人祭·ComiAi、武汉animepower动漫展、ComicParty武汉动漫节<br />
锦州：七夕祭同人展、锦州秋原漫展、锦州市暖冬祭<br />
广州：YACA动漫展、亚洲游戏动漫展、ADSL同人展、萤火虫动漫展、艾妮动漫展（AniEx动漫游戏展）、CICF（中国国际漫画节动漫游戏展）<br />

        </h3>
        </textarea>
    </div>
	<ul id="content">
        
    </ul>
    <div class="loading" id="loading">稍等一下。。。 </div>
    <div class="loading" id="nomoreresults">Sorry,no more data about animenews.</div>
</div>
</body>

</html>
