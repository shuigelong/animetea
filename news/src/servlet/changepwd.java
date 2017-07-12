package servlet;






import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.DBBase;
@WebServlet(name = "Changepwd", urlPatterns = "/changepwd")
public class changepwd extends HttpServlet{
	
	 
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {

		 String username = req.getParameter("username");
	     String password = req.getParameter("password");
	     HttpSession session= req.getSession();
	     System.out.println("-0-"+username+password);
	     //String email = req.getParameter("email");
	     
	     if(DBBase.changepwd(password,username))
	     {
	    	 req.getRequestDispatcher("./success.jsp").forward(req,resp);
	    	 session.setAttribute("user_res", "修改成功");
	     }
	     else
	     {
	    	 req.getRequestDispatcher("./fail.jsp").forward(req,resp);
	    	 session.setAttribute("user_res", "修改失败");
	     }
	 }
	 
	
}
