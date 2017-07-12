package servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.misc.BASE64Decoder; 

import user.DBBase;
import news.Photo;
import news.newsup;

@WebServlet(name = "UpnewsdataServlet", urlPatterns = "/upnewsdata")
public class upnewsdata extends HttpServlet{
	
	 Properties prop = new Properties();  
	 String photoaddress;
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {    
		 req.setCharacterEncoding("UTF-8");
		
		 InputStream in = new BufferedInputStream (new FileInputStream("D:/workspace/news/WebContent/WEB-INF/photo.properties"));
         
		 prop.load(in);   
         String value = prop.getProperty("address");   
         photoaddress=value;
         System.out.println(photoaddress);
         in.close();
		 newsup a=new newsup();
		 
		 
         
	    a.setTitle(req.getParameter("title"));
	    a.setOpentime(req.getParameter("opentime"));
	    a.setDetial(req.getParameter("detial"));
	    a.setAddress(req.getParameter("address"));
	    a.setProvince(req.getParameter("province"));
	    a.setUsername(req.getParameter("user_id"));
	    a.setPhoto(photoaddress);
	   
	    if(DBBase.updatenews(a)){
	    	req.getRequestDispatcher("./success.jsp").forward(req,resp);
		    req.setAttribute("user_res", "上传成功");
	    }
	    else
	    {
	    	req.getRequestDispatcher("./fail.jsp").forward(req,resp);
	    	req.setAttribute("user_res", "上传失败");
	    }
	   
 
	    
	   }
	
}
