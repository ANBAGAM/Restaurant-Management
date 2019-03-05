package com.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.restaurant.data.Employee;
import com.restaurant.dbconnection.ConnectionUtil;

public class EmployeeDAO {

	ResultSet resultSet = null;
	
	public void addEmployee(Employee employee){
		
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
		String sql = "insert into res_employee (id,name,dsgn,gender,dob) values(seq_emp.nextval,?,?,?,?)";
		PreparedStatement preparedStatement;
		int rows;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,employee.getName());
			preparedStatement.setString(2,employee.getDesignation());
			preparedStatement.setString(3,employee.getGender());  
			preparedStatement.setDate(4,Date.valueOf(employee.getDateOfBirth()));
			

			rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Employee> findAll() throws SQLException{
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
		
		String sql = "select id,name,dsgn,gender,dob from  res_employee";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet resultset = stmt.executeQuery();
		
		ArrayList<Employee> emplist=new ArrayList<Employee>();
		while(resultset.next()){
			Employee employee = new Employee();
		employee.setId(resultset.getInt("id"));
		employee.setName(resultset.getString("name"));
		employee.setDesignation(resultset.getString("dsgn"));
		employee.setGender(resultset.getString("gender"));
		employee.setDateOfBirth(resultset.getDate("dob").toLocalDate());
		
		emplist.add(employee);
		}
		return emplist;
		
		
	}
}
