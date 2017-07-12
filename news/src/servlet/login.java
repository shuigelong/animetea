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



@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class login extends HttpServlet{
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
		 String username = req.getParameter("username");
	     String password = req.getParameter("password");
	     HttpSession session= req.getSession();
	     //System.out.println("-0-"+username);
	     
	     if(DBBase.getAccount(username,password)||DBBase.getrootAccount(username, password)){
	    	 req.getRequestDispatcher("./success.jsp").forward(req,resp);
	    	 session.setAttribute("stuid", username);
	    	 session.setAttribute("user_res", "loginsuccess");
	     }
	     else
	     {
	    	 req.getRequestDispatcher("./fail.jsp").forward(req,resp);
	    	 session.setAttribute("user_res", "loginfail");
	     }
	 }
}
