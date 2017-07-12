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


import news.Photo;
import sun.misc.BASE64Decoder;

@WebServlet(name = "UpphotoServlet", urlPatterns = "/upphoto")
public class upphoto extends HttpServlet{
	 
	 int count=0;
	 Properties prop = new Properties();  
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {  
		 
		 InputStream in = new BufferedInputStream (new FileInputStream("D:/workspace/news/WebContent/WEB-INF/photo.properties"));
         prop.load(in);     ///���������б�
         count = Integer.parseInt(prop.getProperty("count")); 
        in.close();
        
		 count++;
		 
		 String image = req.getParameter("image");    
		    // ֻ����jpg   
		    String header ="data:image/jpeg;base64,";    
		    if(image.indexOf(header) != 0){       
		    resp.getWriter().print(wrapJSON(false));  
		    return;  
		    }  
		 // ȥ��ͷ��  
		     image = image.substring(header.length());  
		  // д�����  
		     boolean success = false;    
		     BASE64Decoder decoder = new BASE64Decoder();    
		     try{   
		     byte[] decodedBytes = decoder.decodeBuffer(image);    
		     String imgFilePath ="D://newsphoto/"+count+".jpg";    
		     FileOutputStream out = new FileOutputStream(imgFilePath);  
		     out.write(decodedBytes);  
		     out.close();  
		     success = true;  
		     	    
		    FileOutputStream oFile = new FileOutputStream("D:/workspace/news/WebContent/WEB-INF/photo.properties");//true��ʾ׷�Ӵ�
            prop.setProperty("address", imgFilePath);
            prop.setProperty("count", String.valueOf(count));
            prop.store(oFile, "Update '" + "address" + "' value");  
            oFile.close();
		    
		     }catch(Exception e){  
		     success = false;  
		     e.printStackTrace();      
		     }  
		     resp.getWriter().print(wrapJSON(success));  
		    


		   
		    
		   }
		 private String wrapJSON(boolean success){  
			  
			  
			 return"{\"success\":"+ success +"}";   
			   
			 }  
	}
