<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>帐户修改</title>
<style type="text/css">
   .div_main{width:960px;margin:0 auto;}
   .div_middle{width:960px;height:500px;}
   .div_left{background:#DDDDDD; width:200px;height:500px; float:left;}
   .div_right{background:#EEEEFF; width:760px;height:500px; float:left;}
   .div_uid, .div_pwd, .div_conf, .div_role, .div_btn{width:300px; margin: 0 auto;height:30px;}
   .div_txt{float:left; width:100px;text-align:right; height:24px; line-height: 24px;}
   .div_in{float:left; width:200px; text-align: left;}
   .div_modify {font-size: 12px;width:700px;height:300px;text-align:center;}
   .div_btn{text-align:center;margin-top: 10px;}
   input{font-size: 14px;font-family: arial}
#apDiv2 {
	position:absolute;
	left:719px;
	top:9px;
	width:300px;
	height:200px;
	z-index:2;
}
fieldset{    width: 680px;    }

legend{    margin-left: 8px;    }

.item{
    height: 56px;
    line-height: 36px;
    margin: 10px;
}

.item .item-label{
    float: left;
    width: 80px;
    text-align: right;
}

.item-text{
    float: left;
    width: 244px;
    height: 16px;
    padding: 9px 25px 9px 5px;
    margin-left: 10px;
    border: 1px solid #ccc;
    overflow: hidden;
}

.item-select{
    float: left;
    height: 34px;
    border: 1px solid #ccc;
    margin-left: 10px;
    font-size: 14px;
    padding: 6px 0px;
}

.item-submit{
    margin-left: 88px;
}

input.error{
    border: 1px solid #E6594E;
}

input.highlight{
    border: 1px solid #7abd54;
}

label.error,label.tip{
    float: left;
    height: 32px;
    line-height: 32px;
    font-size: 14px;
    text-align: left;
    margin-left: 5px;
    padding-left: 20px;
    color: red;
    background: url('error.png') no-repeat left center;
}

label.tip{
    color: #aaa;
    background: url('tip.png') no-repeat left center;
}

label.valid{
    background: url('valid.png') no-repeat left center;
    width: 32px;
}   
</style>
<script src="js/bootstrap.min.js"></script>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="vaildate/jquery.validate.min.js"></script>
<script src="vaildate/jquery.validate.extend.js"></script>
<script type="text/javascript">

$(document).ready(function(){
    $("#changeForm").validate({
        rules: {
            username:{
                required: true,
                minlength: 2
            },
            password:{
                required: true,
                minlength: 6,
                maxlength: 16
            },
            repassword:{
                required: true,
                equalTo: "#password"
            },
            amt: {
                required: true,
                amtCheck: true
            }
        },
        messages:{
            username:{
                required: "用户名不能为空",
                minlength: "用户名的最小长度为2"
            },
            password:{
                required: "密码不能为空",
                minlength: "密码长度不能少于6个字符",
                maxlength: "密码长度不能超过16个字符"
            },
            repassword:{
                required: "确认密码不能为空",
                equalTo: "确认密码和密码不一致"
            },
           
        }
    });
});
</script>
		<script type="text/javascript">
		function getCookie(c_name)
		{
		if (document.cookie.length>0)
		  {
		  c_start=document.cookie.indexOf(c_name + "=")
		  if (c_start!=-1)
		    { 
		    c_start=c_start + c_name.length+1 
		    c_end=document.cookie.indexOf(";",c_start)
		    if (c_end==-1) c_end=document.cookie.length
		    return unescape(document.cookie.substring(c_start,c_end))
		    } 
		  }
		return ""
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
                <div class="menu2"><a href="index.html"><img src="img/return.png" width="200" height="100" /></a></div> 
           </div>
        </div>
        </div>
        <div class="div_right">
				<div>
					<div class="title_menu1">账户管理</div>
					<div class="title_menu2">  -- 账号密码修改</div>
					<br/><hr/>
				</div>
					<form action="./changepwd" method="post" id="changeForm" >
                    <% String stuid= (String)session.getAttribute("stuid"); %> 
					<input type="hidden" value=<%=stuid %> name="username"></input>
                      <div id="apDiv1"> 
                       <div class="item">
                           <label for="password" class="item-label">password:</label>
                           <input type="password" id="password" name="password" class="item-text" placeholder="设置密码"
                                tip="长度为6-16个字符">
                       </div>
                       <div class="item">
                           <label for="password" class="item-label">again:</label>
                           <input type="password" name="repassword" class="item-text" placeholder="设置确认密码">
                       </div>
                       <div class="item">
                             <input type="submit" value="提交" class="item-submit">
                         </div>

                     </div>
                    </form>
			</div>
			
		</div>
        </div>
   </div>

</div>
</body>
</html>