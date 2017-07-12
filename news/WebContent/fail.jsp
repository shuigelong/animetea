<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


  <script type="text/javascript">
  
  var i=5;
  var mes = '<%=session.getAttribute("user_res")%>';
  function massage(){
	  i--;
	  if(mes=="loginfail")
	  document.getElementById("div_a").innerHTML=mes+":"+i+"返回登陆页面";
	  if(mes=="上传失败")
	  document.getElementById("div_a").innerHTML=mes+":"+i+"返回上传页面";
	  else  
	  document.getElementById("div_a").innerHTML=mes+":"+i+"返回注册页面";	  
  }
  
  function a()
  {
	  if(mes=="登陆失败")
	  window.location="user_manage.jsp";
	  if(mes=="上传失败")
	  window.location="upnewsdate.jsp";
	  else
	  window.location="user_manage.jsp";	 
  }
  function timedMsg()
  {
  
  setTimeout('a()',5000);
  setInterval('massage()',1000);
  }
  timedMsg();
  </script>
 
</head>
<body style="background-image: url(img/background.jpg);
background-color: #94AAD6;
background-position: center;
background-repeat: no-repeat;
background-attachment: fixed;">


<!-- è¿æ¯å¼å¤´ -->
<center>
<table border="0" width="960" height="112" >
<tr>
     <td width="786" height"66"></td>
     <td width="164" ></td>
     </tr>
     <tr>
     <td height="40"></td>
     <td valign="top" ></td>
</tr>
</table>

<div id="div_a"></div>



</body>
</html>