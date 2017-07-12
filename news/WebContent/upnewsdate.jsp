<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
<style type="text/css">
   .div_main{width:960px;margin:0 auto;}
   .div_middle{width:960px;height:500px;}
   .div_left{background:#DDDDDD; width:200px;height:500px; float:left;}
   .div_right{background:#EEEEFF; width:760px;height:500px; float:left;}
   
   #preview{width:260px;height:190px;border:1px solid #000;overflow:hidden;}
#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}



</style>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script>
 var image = '';
 function selectImage(file){
 if(!file.files || !file.files[0]){
return;
}
 var reader = new FileReader();
 reader.onload = function(evt){
 document.getElementById('image').src = evt.target.result;
 image = evt.target.result;
}
reader.readAsDataURL(file.files[0]);
}
 function uploadImage(){

$.ajax({

type:'POST',

 url: './upphoto', 

 data: {image: image},

 async: false,

 dataType: 'json',

 success: function(data){

if(data.success){

alert('上传成功');

}else{

alert('上传失败');

}

},

 error: function(XMLHttpRequest, textStatus, errorThrow){

	 alert(XMLHttpRequest.status);
	 alert(XMLHttpRequest.readyState);
	 alert(textStatus);

}

});

}
</script>


 	<script type="text/javascript">
 	function keyPress() {    
 	     var keyCode = event.keyCode;    
 	     if ((keyCode >= 48 && keyCode <= 57))    
 	    {    
 	         event.returnValue = true;    
 	     } else {    
 	           event.returnValue = false;    
 	    }    
 	 }   
 	
 	
			function check()
			{
				var title=document.getElementById("title").value;
				var opentime=document.getElementById("opentime").value;
				var detial=document.getElementById("detial").value;
				var province=document.getElementById("province").value;
				var address=document.getElementById("address").value;	
				
				var bResult=true;
				var stMsg="";
				if(title.length>50) 
				{
					bResult=false;
					stMsg="新闻标题必须少于25个字！";
					document.getElementById("title").focus();
				}
				if(opentime<1&&opentime>12) 
				{
					bResult=false;
					stMsg="请输入正确的月份";
					document.getElementById("brief").focus();
				}
				if(detial.length<50) 
				{
					bResult=false;
					stMsg="输入的新闻不得少于25字！";
					document.getElementById("brief").focus();
				}
				if(category<=0) 
				{
					bResult=false;
					stMsg="请选择成果类型！";
					document.getElementById("category").focus();
				}
				if(category.length*title.length*brief.length==0)
				{
					bResult=false;
					stMsg="请完成填写所有内容！";
				}

				if(!bResult) alert(stMsg);
				return bResult;
			}
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
                <div class="menu2"><a href="index.jsp"><img src="img/return.png" width="200" height="100" /></a></div> 
           </div>
           
        </div>
        </div>
        <div class="div_right">
        <form action="./upnewsdata"  method="post" id="changeForm"  onsubmit="return check()" >
        <%String stuid=(String)session.getAttribute("stuid"); %>
			<input type="hidden" value=<%=stuid %> name="user_id"></input>
			<div class="div_modify">
						<div class="div_development_id">
						<!---->
						 <!--    <div class="item">
                           <label for="password" class="item-label">password:</label>
                           <input type="password" id="password" name="password" class="item-text" placeholder="设置密码"
                                tip="长度为6-16个字符">    
                           </div>   -->
	                       <div class="div_title">
	                            
			                 <div class="div_txt">漫展信息标题：</div>
				                <div class="div_in"><input type="text" name="title" id="title" size="30"/></div> 
				                
						   </div>
						        <div class="div_title">
						            <div class="div_txt">漫展时间：</div>
						            <div class="div_in"><input type="text" name="opentime" id="opentime" size="20" onpaste="return false;"  onkeypress="keyPress()" /></div>
						        </div>
						        
						        <div class="div_brief">
						            <div class="div_txt">正文：</div>
						            <div class="div_in"><textarea name="detial" id="detial" cols="80" rows="6"></textarea></div>
						            
						        </div>
						    <div class="div_title">
			                    <div class="div_txt">省份：</div>
				                <div class="div_in"><input type="text" name="province" id="province" size="10"/></div>
						   </div>
						     <div class="div_title">
			                    <div class="div_txt">详细地址：</div>
				                <div class="div_in"><input type="text" name="address" id="address" size="40"/></div>
						   </div>
						      <div class="div_title">
						       <div class="div_txt">上传图片：</div>
						       <input type="file" name="photo" style="width: 200px; height: 20px;" onchange="selectImage(this);" id="photo" />
						       <img id="image"src=""/>

                           <!--  <div id="imgPreview" style="width:120px; height:100px;margin-left: 280px;"> -->
                             <input type="button"onclick="uploadImage();"value="上传"/>
                            </div>
						      </div>
						        <div class="div_btn">
						            <input type="submit" value="提交" name="btnsubmit"  />
						            <input type="reset" name="btnreset"/>
						        </div>
						</div>
					</form>
        </div>
   </div>

</div>
</body>
</html>