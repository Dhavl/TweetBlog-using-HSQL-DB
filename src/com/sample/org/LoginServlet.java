package com.sample.org;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("Bean.xml");
	loginAction action = (loginAction) ctx.getBean("loginAction", loginAction.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
		String var = request.getParameter("var");
		if(var!=null)
		{	
		 if(var.equals("signup"))
		 {
			rd = request.getRequestDispatcher("/signup.jsp");
			rd.forward(request, response);
			return;
		 }
		 if(var.equals("back"))
		 {
			 rd = request.getRequestDispatcher("/jsp/login.jsp");
		     rd.forward(request, response);
		     return;
		 }	 
		}
		
		else
		{
			request.setAttribute("tgs",TweetAction.findall());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		HttpSession session = request.getSession();
		String var = request.getParameter("var");
		if(var!=null){
		  if(var.equals("login")){
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				String check = action.search(username,password);
				if(check == "Failed")
				{
					System.out.println("Errorrrr......");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				}
				if(check == "ValidUser")
				{
					System.out.println("Welcome....."+username);
					session.setAttribute("username", username);
					
					//System.out.println("Session id" +session.getId());
					
					request.changeSessionId();
					
					request.setAttribute("tgs",TweetAction.findall());
					
					request.getRequestDispatcher("/home1.jsp").forward(request, response);	
				}
			}
			
			else if(var.equals("signup"))
			{				
				String username = request.getParameter("un");
				String password = request.getParameter("pw");
				//String cpassword = request.getParameter("cpw");
				
				String check = action.insert(username,password);
				
					if(check == "Success")
					{
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
					else if(check == "AlreadyExists")
					{
						request.setAttribute("UserExists", null);
						request.getRequestDispatcher("/signup.jsp").forward(request, response);
					}
					else if(check == "Failed")
					{
						request.getRequestDispatcher("/signup.jsp").forward(request, response);
					}
					/*
					else if(action.insert(request, response).equals("Success")){
					
						request.getRequestDispatcher("/login.jsp").forward(request, response);						
					}*/	
			}
		}
	}
}


