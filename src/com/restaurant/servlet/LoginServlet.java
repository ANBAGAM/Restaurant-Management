	package com.restaurant.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.LoginDAO;
import com.restaurant.data.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		long loginId=Long.parseLong(request.getParameter("loginId"));
		String password=request.getParameter("password");
		
		System.out.println(loginId);
		System.out.println(password);
		Login login = new Login();
		login.setLoginid(loginId);
		login.setPassword(password);
		
		LoginDAO loginDAO = new LoginDAO();
		if(loginId>1001 && loginId<2000){
			try {
				boolean b=loginDAO.checkEmployee(login);
				if(!b){
					
					System.out.println("Present");
					boolean c=loginDAO.checkEmployeePass(login);
					if(c){
						request.setAttribute("errMsg", " success ");
						 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");//admin.jsp
						    rd.forward(request, response); 
					}
					else{
						request.setAttribute("errMsg", " !!! Invalid Password ");
						 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						    rd.forward(request, response); 
					}
				}
				else{
					 request.setAttribute("errMsg", " Please Enter a Valid Employee ID ");
					 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					    rd.forward(request, response); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else{
			 request.setAttribute("errMsg", " Please Sign Up to login ");
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			    rd.forward(request, response); 
		}
		
		
		
		
	}

}
