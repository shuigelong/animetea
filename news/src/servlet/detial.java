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
import javax.servlet.http.HttpSession;

import news.commit;
import news.newsdate;
import user.DBBase;

@WebServlet(name = "DetialServlet", urlPatterns = "/detial")
public class detial extends HttpServlet{
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
		  // resp.setHeader("Pragma","no-cache");
	      // resp.setHeader("Cache-Control","no-cache");
	      // resp.setDateHeader("Expires", 0); 
	       req.setCharacterEncoding("UTF-8");
	       String username=null,commit=null;
	       HttpSession session= req.getSession();
	String title=req.getParameter("title");
	
	System.out.println(title+"get");
	 session.setAttribute("commitnews",title);
if(title==null){
	System.out.println("none");
     resp.getWriter().write("");
}
else{
	PrintWriter out=resp.getWriter();
	 List<commit> resultpost =DBBase.commit(title);
	// System.out.println(title);
	 for(commit rtc:resultpost){
		 username=rtc.getUsername();
		 commit=rtc.getCommit();
		 System.out.println(commit);
		 int uid= (int) session.getAttribute(""+title+"");
	//	 System.out.println("address"+uid);
		 String url=uid+"/jsp;charset=utf-8";
		 System.out.println(url);
		 resp.setContentType(url);
		 out.println(" <p>user:"+username+"<br>"+commit+"</p>");
		
    	 System.out.println("情况"+username+commit);
	 }
	   out.flush();
	   out.close();
	 }
} 
	 
	 
	 
	 
	 

}
