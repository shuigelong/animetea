package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import news.newsdate;
import news.newsup;
import user.DBBase;

@WebServlet(name = "NewsServlet", urlPatterns = "/news")
public class news extends HttpServlet{
	
   public news(){
	   super();
   }
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException { 
	   resp.setHeader("Pragma","no-cache");
       resp.setHeader("Cache-Control","no-cache");
       resp.setDateHeader("Expires", 0);
       String title = null,time = null;
       int uid;
       String detitle=null,deopentime=null,dedetial=null,deaddress=null,deprovince=null,deusername=null,dephoto=null;
      // String pagesize= req.getParameter("pagesize");
       HttpSession session= req.getSession();
      // String pageindex = req.getParameter("pagenumber");
       
      // String province =req.getParameter("province");
       
     // int  pagesize1=Integer.parseInt(pagesize);
   //   int  pageindex1=Integer.parseInt(pageindex);
    //  System.out.println(pageindex1);
      //HashMap<String,String> 
      int a=1; 
      int b=DBBase.count();
      resp.setCharacterEncoding("UTF-8");
      
      //pagesize==null||
       if(a>3){
    	   resp.getWriter().write("");
          }
       else{
    	   PrintWriter out=resp.getWriter();
    	   List<newsdate> resultpost =DBBase.checknews(a,b);
    	   a++;
    	   String json = JSON.toJSONString(resultpost);
    	   for(newsdate rt:resultpost){
    		   title=rt.getTitle();
    		   time=rt.getTime(); 
    		   uid=rt.getUid();
    		  // String uid1= String.valueOf(uid);
    		   List<newsup> detial=DBBase.detial(uid);
    		   //String detialjson = JSON.toJSONString(detial);
    		   for(newsup de:detial){
    			   detitle=de.getTitle();
    			   deopentime=de.getOpentime();
    			   dedetial=de.getDetial();
    			   deaddress=de.getAddress();
    			   deprovince=de.getProvince();
    			   deusername=de.getUsername();
    			   dephoto=de.getPhoto();
    		   }
    		 //模板路径
    		   String filePath = "D:/workspace/news/WebContent/detial.jsp";
    		//   System.out.print(filePath);
    		   String templateContent = "";
    		   FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
    		   int lenght = fileinputstream.available();
    		   byte bytes[] = new byte[lenght];
    		   fileinputstream.read(bytes);
    		   fileinputstream.close();
    		   templateContent = new String(bytes);
    		  // System.out.print(templateContent);
    		   templateContent = templateContent.replaceAll("XXtitleXX", detitle);
    		   templateContent = templateContent.replaceAll("XuseX", deusername);
    		   templateContent = templateContent.replaceAll("XmonthX",deopentime);
    		   templateContent = templateContent.replaceAll("XaddX",deaddress);
    		   templateContent = templateContent.replaceAll("XXXdeXXX",dedetial);
    		   templateContent = templateContent.replaceAll("XphX",dephoto);
    		   // 替换掉模板中相应的地方
    		 // System.out.print(templateContent);
    		   // 根据时间得文件名
    		   Calendar calendar = Calendar.getInstance();
    		   String fileame = uid+ ".jsp";
    		   fileame = "D:/workspace/news/WebContent/" + fileame;// 生成的html文件保存路径。
    		   FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
    		  // System.out.print("文件输出路径:");
    		  // System.out.print(fileame);
    		   byte tag_bytes[] = templateContent.getBytes();
    		   fileoutputstream.write(tag_bytes);
    		   fileoutputstream.close();
    	  
    		   
    		   session.setAttribute(""+title+"", uid);
    		   
    	   //JSONArray json = JSONArray.fromObject(resultpost);   
    	   //System.out.println(json);
    	     //  System.out.println(title);
    	     //  System.out.println(time);
    	       resp.setContentType("index/jsp; charset=utf-8");
          // try(PrintWriter out=resp.getWriter()){
        	   //out.write(json);
               out.println(" <li  style='opacity:0;-moz-opacity: 0;filter: alpha(opacity=0);'><a  href=\""+uid+".jsp\" >");
          	   out.println(uid+"<br>标题："+title+"<br>"+"举办时间：2017年"+time+"月</a></li>");
          	  }
    	   //}
    	   out.flush();
      	   out.close();
           }
	   
   }
}
