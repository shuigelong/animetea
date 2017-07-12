
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<html>
<body>
 <%
  String username= (String)session.getAttribute("stuid");
  if(username==null)
  {%>
	<jsp:forward page="login.jsp"/>

<% 	
} %>
 

<center>
<table border="0" width="960" height="112" background="img/titletwo.png" >
<tr>
     <td width="786" height"66"></td>
     <td width="164" ></td>
     </tr>
     <tr>
     <td height="40"></td>
     <td valign="top" ><img src="img/currentuid.png" width="66" height="46" />: <%=username%> </td>
     
    

</tr>



</table>
</center>
</body>
</html>