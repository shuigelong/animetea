package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import news.commit;
import user.DBBase;


@WebServlet(name = "InfornationServlet", urlPatterns = "/infornation")
public class infornation extends HttpServlet{
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
		 req.setCharacterEncoding("UTF-8");
	     String title=null,user=null,commint=null;
	     HttpSession session= req.getSession();
	     resp.setCharacterEncoding("UTF-8");
	     System.out.println("xinxxi"+req.getParameter("commint")+req.getParameter("user")+req.getParameter("title"));
	     if(DBBase.upcommit(req.getParameter("commint"),req.getParameter("user"),req.getParameter("title"))){
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
