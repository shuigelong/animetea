package user;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import news.commit;
import news.usernews;
import news.newsdate;
import news.newsup;


public class DBBase {
	   public static final String url = "jdbc:mysql://localhost:3306/animetea?useSSL=false";  
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "root";  
	    public static final String password = "757141174ty";  
	  
	    public static Connection conn = null;  
//建立连接============================================================	   
	    public static Connection connectDB() {  
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
			return conn;  
	    }  
	  
	    public static void closeDB() {  
	    	 {
	    		   try
	    		   {
	    			   conn.close();
	    		   }
	    		   catch(Exception e)
	    		   {
	    			   e.printStackTrace();  
	    		   }
	    	   }
	    }  
//注册账号=======================================================================================================	    
	    public static boolean regAccount(String reguid,String regpwd )
		{
			boolean regResult=true;
			int update=0;
			int change=0;
			//System.out.println("a"+reguid+regpwd);
			try{
				DBBase.connectDB();
				Statement ste=conn.createStatement();
				boolean we=ste.execute("insert into animetea.user(username,password,upnews,changenews)values('"+reguid+"','"+regpwd+"','"+update+"','"+change+"')");
			   if(we)
			      {
				   regResult=false;
			      }
			   else
			      {
				   regResult=true;
			      }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return regResult;	
		}
//登录账号===========================================================================================
		public static boolean getAccount(String  uid,String pwd)
		{
			boolean bResult=true;
			try{
				connectDB();
				Statement sta=conn.createStatement();
				ResultSet we=sta.executeQuery("select * from user where username='"+uid+"' and password='"+pwd+"'");
			   if(!we.next())
			      {
				   bResult=false;
			      }
			   we.close();
			   sta.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;
			}
//登陆root账号==================================================================================================
	    public static boolean getrootAccount(String  uid,String pwd)
		{
			boolean bResult=true;
			try{
				connectDB();
				Statement sta=conn.createStatement();
				ResultSet we=sta.executeQuery("select * from root where root_name='"+uid+"' and root_password='"+pwd+"'");
			   if(!we.next())
			      {
				   bResult=false;
			      }
			   we.close();
			   sta.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;
			}	    
//修改账号密码=======================================================================================================
		public static boolean changepwd(String cpwd,String uid)
		{
			boolean bResult=true;
			try{
				connectDB();
				Statement ste=conn.createStatement();
                 System.out.println("密码"+cpwd+uid);
				boolean we=ste.execute("update user set password='"+cpwd+"' where username='"+uid+"'");
			   if(we)
			      {
				   bResult=false;
			      }
			   else
			      {
				   bResult=true;
			      }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;	
		}
//修改账号权限=========================================================================================================
		public static boolean changerole(String role_id,String uid)
		{
			boolean bResult=true;
			try{
				connectDB();
				Statement ste=conn.createStatement();
				boolean we=ste.execute("update user set role_id='"+role_id+"' where uid='"+uid+"'");
			   if(we)
			      {
				   bResult=false;
			      }
			   else
			      {
				   bResult=true;
			      }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;	
		}
//上传漫展信息============================================================================
		public static boolean updatenews(newsup update){
			boolean bResult=true;
			try{
				connectDB();
				Statement ste=conn.createStatement();
	        boolean we=ste.execute("insert into news(title,opentime,province,detial,address,username,photo) "
	        		+ "VALUES('"+update.getTitle()+"',"
	        				+ "'"+update.getOpentime()+"',"
	        						+ "'"+update.getProvince()+"',"
	        								+ "'"+update.getDetial()+"',"
	        										+ "'"+update.getAddress()+"',"
	        												+ "'"+update.getUsername()+"','"+update.getPhoto()+"')");
			   if(we)
			      {
				   bResult=false;
			      }
			   else
			      {
				   bResult=true;
			      }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;	
		}
 //查询漫展信息===============================================================================
		
		//public static  ArrayList<newsdate>  checknews(int pagesize,int pageindex){
	    public static  List<newsdate>  checknews(int pageindex, int pagesize){	
			  List<newsdate>  res =  new ArrayList<newsdate>();  
			  int c_b;
			  if(pageindex==1)
			  {
				  
				  c_b=0;
			  }
			  else{
			  
			     c_b=pageindex*pagesize-1-pagesize;
			  }
			try{connectDB();
				Statement ste=conn.createStatement();
				ResultSet we=ste.executeQuery("select uid,title,opentime from news limit "+c_b+","+pagesize+"");
			    while(we.next()){
			    newsdate r=new newsdate();	
				r.setTime(we.getString("opentime"));
			    r.setTitle(we.getString("title"));
			    r.setUid(we.getInt("uid"));
           	    res.add(r);
			    }
			  //System.out.println(title.size());
			   ste.close();
		       DBBase.closeDB();
	
             
            }
            
		
			catch(Exception e)
			       {
				   e.printStackTrace();
			       }
			
			return res;
		}

//详细拉取漫展信息===================================================================
	    public static  List<newsup>  detial(int uid){	
			  List<newsup>  resa =  new ArrayList<newsup>();  
			try{connectDB();
				Statement ste=conn.createStatement();
				ResultSet wen=ste.executeQuery("select * from animetea.news where uid="+uid+"");
			    while(wen.next()){
			    newsup ra=new newsup();
			    ra.setUid(uid);
			    ra.setAddress(wen.getString("address"));
			    ra.setDetial(wen.getString("detial"));
			    ra.setOpentime(wen.getString("opentime"));
			    ra.setPhoto(wen.getString("photo"));
			    ra.setProvince(wen.getString("province"));
			    ra.setTitle(wen.getString("title"));
			    ra.setUsername(wen.getString("username"));
         	    resa.add(ra);
			    }
			  //System.out.println(title.size());
			   ste.close();
		       DBBase.closeDB();
	
           
          }
          
		
			catch(Exception e)
			       {
				   e.printStackTrace();
			       }
			
			return resa;
		}
//拉取评论信息===========================================
	    public static  List<commit>  commit(String title){
	    	 List<commit>  resb =  new ArrayList<commit>();  
	    	 try{connectDB();
	    		 Statement ste=conn.createStatement();
				ResultSet wec=ste.executeQuery("select speech_username,commit from animetea.speech where news_title='"+title+"'");
				while(wec.next()){
				    commit rc=new commit();
				    rc.setUsername(wec.getString("speech_username"));
				    rc.setCommit(wec.getString("commit")); 
	         	    resb.add(rc);
	         	    
				    }
				    ste.close();
			       DBBase.closeDB();
	    	 }
	    	 catch(Exception e)
		       {
			   e.printStackTrace();
		       }
	    	 return resb;
	    }
	    
	    
//上传评论信息===========================================
	    public static boolean upcommit(String commit,String commituse,String news_title){
			boolean bResult=true;
			try{
				connectDB();
				Statement ste=conn.createStatement();
				boolean we=ste.execute("insert into animetea.speech(news_title,commit,speech_username)values('"+news_title+"','"+commit+"','"+commituse+"')");
			   if(we)
			      {
				   bResult=false;
			      }
			   else
			      {
				   bResult=true;
			      }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return bResult;	
	    }
 //详细拉取漫展信息===================================================================
	    public static  List<usernews>  usernews(String username1){
	    	//System.out.println("runclass");
			  List<usernews>  resa =  new ArrayList<usernews>();  
			try{
				//System.out.println("runbase");
				connectDB();
				Statement ste=conn.createStatement();
				ResultSet wen1=ste.executeQuery("select uid,title from animetea.news where username='"+username1+"'");
				System.out.println("runbase"+"select uid,title from animetea.news where username='"+username1+"'");
			    while(wen1.next()){
			    	System.out.println("runsave");
			    usernews ra=new usernews();
			    ra.setUsername(username1);
			    ra.setUid(wen1.getInt("uid"));
			    ra.setTitle(wen1.getString("title"));
			    System.out.println("set"+wen1.getInt("uid"));
         	    resa.add(ra);
			    }
			  //System.out.println(title.size());
			   ste.close();
		       DBBase.closeDB();
	
           
          }
          
		
			catch(Exception e)
			       {
				   e.printStackTrace();
			       }
			
			return resa;
		}
//查询数据个数====================================================
	    public static int count()
		{
			int c=0;
			try{
				connectDB();
				Statement ste=conn.createStatement();
                
				ResultSet wen1=ste.executeQuery("select count(uid) from animetea.news");
				 while(wen1.next()){
					 c=wen1.getInt("count(uid)");	    
				 }
			   ste.close();
			   DBBase.closeDB();
			   }
			catch(Exception e)
		       {
			   e.printStackTrace();
		       }
			return c;	
		}
	    
		
}
