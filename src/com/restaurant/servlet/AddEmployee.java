package com.restaurant.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.EmployeeDAO;
import com.restaurant.data.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
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
	
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String bday=request.getParameter("bday");
		LocalDate dob=LocalDate.parse(bday);
		
		String designation = request.getParameter("designation");
		
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setGender(gender);
		employee.setDateOfBirth(dob);
		employee.setDesignation(designation);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.addEmployee(employee);
		
		RequestDispatcher rd = request.getRequestDispatcher("addEmployee.html");
		rd.forward(request, response);
	
	}

}
