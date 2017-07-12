<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登陆</title>

<style type="text/css">
body{
    font-family: Microsoft Yahei;
    font-size: 15px;
    background-image: url(img/background2.png);
    background-color: #f7e3dc;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
}
#apDiv1 {
	position:absolute;
	text-align:center;
	left:722px;
	top:238px;
	z-index:1;
}
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
    $("#regForm").validate({
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
          
           
        }
    });
});
</script>
<script type="text/javascript">


</script>

</head>
<body >


<form action="./login" method="post" id="regForm" >
<div id="apDiv2"><img src="img/title.png" width="300" height="200" /></div>
<div id="apDiv1"> 
        <div class="item">
            <label for="username" class="item-label"><img  src="img/uid.png"></label>
            <input type="text" id="username" name="username" class="item-text" placeholder="请输入用户名"
            autocomplete="off" tip="请输入用户名">
        </div>
        <div class="item">
            <label for="password" class="item-label"><img  src="img/pwd.png"></label>
            <input type="password" id="password" name="password" class="item-text" placeholder="请输入密码"
            tip="长度为6-16个字符">
        </div>
        
       
        <div class="item">
            <input type="submit" value="提交" class="item-submit">
        </div>

</div>
</form>
</body>
</html>