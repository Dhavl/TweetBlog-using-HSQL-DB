package com.sample.org;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String var = request.getParameter("var");
		
		if(var!=null)
		{
			if(var.equals("submit"))
			{
				String username = (String) session.getAttribute("username");
				if(username!=null)
				{
				TGetsSets st = new TGetsSets();
				
				
				String usercomments = request.getParameter("uc");
				
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd");
				Date d =new Date();
				String dat = dateFormat.format(d);
				
				st.setUsername(username);
				st.setComment(usercomments);
				st.setDate(dat);
				
				TweetAction.insert(st);
				
				request.setAttribute("tgs",TweetAction.findall());
				
				request.getRequestDispatcher("/home1.jsp").forward(request, response);
				//response.sendRedirect("TweetBlog/DisplayBlog");
				}
				else
				{					
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				}
			}
		}
	}

}
