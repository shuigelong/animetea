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

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class register extends HttpServlet {
 
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req, resp);
 }
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {

	 String username = req.getParameter("username");
     String password = req.getParameter("password");
     System.out.printf(username+password);
     HttpSession session= req.getSession();
     
     //String email = req.getParameter("email");
     
     if(DBBase.regAccount(username,password))
     {
    	 req.getRequestDispatcher("./success.jsp").forward(req,resp);
    	 session.setAttribute("user_res", "注册成功");
     }
     else
     {
    	 req.getRequestDispatcher("./fail.jsp").forward(req,resp);
    	 session.setAttribute("user_res", "注册失败");
     }
 }
 
}
