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
@WebServlet(name = "Changerole", urlPatterns = "/changerole")
public class changerole extends HttpServlet{
	
	 
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {

		 String username = req.getParameter("username");
	     String role = req.getParameter("role");
	     HttpSession session= req.getSession();
	     
	     //String email = req.getParameter("email");
	     
	     if(DBBase.changerole(role,username) )
	     {
	    	 req.getRequestDispatcher("./success.jsp").forward(req,resp);
	    	 session.setAttribute("user_res", "�޸ĳɹ�");
	     }
	     else
	     {
	    	 req.getRequestDispatcher("./fail.jsp").forward(req,resp);
	    	 session.setAttribute("user_res", "�޸�ʧ��");
	     }
	 }
	 
	
}