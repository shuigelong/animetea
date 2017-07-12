package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.commit;
import news.newsup;
import news.usernews;
import user.DBBase;

@WebServlet(name = "NewslistServlet", urlPatterns = "/newslist")
public class newslist extends  HttpServlet{
	
	  
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException { 
		   resp.setHeader("Pragma","no-cache");
	       resp.setHeader("Cache-Control","no-cache");
	       resp.setDateHeader("Expires", 0);
	       String title = null,username = null;
	       int uid;
	       resp.setCharacterEncoding("UTF-8");
	       username=req.getParameter("user").trim();
	       System.out.println(username);
	       usernews a=new usernews();  
	       if(username==null){
	    	   resp.getWriter().write("");
	       }
	       else
	       {
	    	   System.out.println("run");
	    	   PrintWriter out=resp.getWriter();
	    	   List<usernews> resultpost =DBBase.usernews(username);
	    		 for(usernews rtc:resultpost){
	    			username=rtc.getUsername();
	    			title=rtc.getTitle();
	    			uid=rtc.getUid();
	    			 System.out.println("run2"+title);
	    			
	    		//	 System.out.println("address"+uid);
	    			 resp.setContentType("manage/jsp; charset=utf-8");
	    			 out.println(" <p> number:"+uid+"username:"+username+"title:"+title+"</p> ");
	    			 
	    	    	 
	    	    	 System.out.println(out);
	    		   }
	    		   out.flush();
	    		   out.close();
	    	   
	       }
	       
		    
		   
		   
	   }
}
