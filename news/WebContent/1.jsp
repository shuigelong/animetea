<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>animeteanews</title>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/scrollpagination.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="scrollpagination_demo.css" rel="stylesheet" media="screen" />
<style type="text/css">
 #commint{
 width:"600";
 height:"100";
 }
</style>


<script type="text/javascript">

$(document).ready(function(){
	var titles=$("#title").text();
$.ajax({
	type:'GET',
	 url: './detial', 
	 data: {'title':titles},
	 async: false,
	 dataType: 'json',
	 success: function(data){ 
			 $("#comit").append(data); 
			 },
     error: function(XMLHttpRequest, textStatus, errorThrow){
			 	 alert(XMLHttpRequest.status);
			 	 alert(XMLHttpRequest.readyState);
			 	 alert(textStatus);
			 },
	dataType: 'html'		 
			 });
})




</script>
<script type="text/javascript">

</script>


</head>

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
<div class="about">
        <h1 id="title">AfterSchool02端午祭</h1>
    </div>
<div class="about">
<h3>USER：lanlan<br>Time：2017-5<br> Address：山东省 青岛市 市北区 华秀国际会展中心3号馆 </h3>
</div>   
  
<div class="about">
<h3>Detial：</h3>
<h3>时间：2017.05.28—29
地点：华秀国际会展中心3号馆（青岛市市北区四流南路80号纺织谷）
票价：预售40RMB 现场45RMB</h3>
<img  src="img/3.jpg">
</div> 
<div class="about">
<form id="upcommit" action="./infornation"  method="post" >
<input type="hidden" value="AfterSchool02端午祭" name="title"></input>
user:<input type="text" id="user" name="user"/><br/>
comment<input type="text" id="commint" name="commint" /><br/>
<input type="submit" value="send"/>
</form>


</div>
<div id="scrollpaginationdemo">
   <div class="about" id="comit">
   </div>
	
    
   </div>
</body>
</html>