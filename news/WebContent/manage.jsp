<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>newslist</title>
<style type="text/css">
   .div_main{width:960px;margin:0 auto;}
   .div_middle{width:960px;height:500px;}
   .div_left{background:#DDDDDD; width:200px;height:500px; float:left;}
   .div_right{background:#EEEEFF; width:760px;height:500px; float:left;}
</style>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script>
$(document).ready(function(){
	var use=$("#user").text();
$.ajax({
	type:'GET',
	 url: './newslist', 
	 data: {'user':use},
	 async: false,
	 dataType: 'json',
	 success: function(data){ 
		    
			 $(".div_right").append(data); 
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

</head>
<body style="background-image: url(img/background.jpg);
background-color: #94AAD6;
background-position: center;
background-repeat: no-repeat;
background-attachment: fixed;">
<div class="div_main">
   <div class="div_top">
   <!-- 这是开头 -->
   <%@ include file="top.jsp"%>  
   </div>
   <div class="div_middle">
        
   
        <div class="div_left">
        <div class="menu0">
           
            <div class="menu2_all">
                 <div class="menu2"><a href="user_manage.jsp"><img src="img/uidmassage.png" width="200" height="100" /></a></div> 
              <div class="menu2"><a href="changepwd.jsp"><img src="img/changepwd.png" width="200" height="100" /></a></div>
              <div class="menu2"><a href="upnewsdate.jsp"><img src="img/watch.png" width="200" height="100" /></a></div>
               <div class="menu2"><a href="manage.jsp"><img src="img/newtitle.png" width="200" height="100" /></a></div>
                <div class="menu2"><a href="index.html"><img src="img/return.png" width="200" height="100" /></a></div> 
           </div>
           
        </div>
        </div>
        <div class="div_right">
          <%
String uida= (String)session.getAttribute("stuid");
String pwda= (String)session.getAttribute("stpwd");       
 %>
 <table width="200" border="0" align="center">
  <tr>
    <td id="user"> <%=uida %></td>
  </tr>
  
</table>
        </div>
        </div>
        </div>
       

</body>
</html>