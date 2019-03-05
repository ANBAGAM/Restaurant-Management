package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.data.Login;
import com.restaurant.dbconnection.ConnectionUtil;

public class LoginDAO {
	ResultSet resultSet = null;

	
	public boolean checkEmployee(Login login) throws SQLException{
		boolean check = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id from res_emp_cre where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setLong(1, login.getLoginid()); 
		resultSet = preparedStatement.executeQuery();

		try {
			if (resultSet.next()) {
			
				check = false;
				ConnectionUtil.close(connection, preparedStatement, resultSet);
				return check;
				
				
			} else {
				check = true;
				ConnectionUtil.close(connection, preparedStatement, resultSet);
				return check;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return check;

	}
	
	
	public boolean checkEmployeePass(Login login) throws SQLException{
		
		boolean checkp = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from res_emp_cre where id=? and pass=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		try {
			preparedStatement.setLong(1, login.getLoginid());
			preparedStatement.setString(2, login.getPassword());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

			//	String checkUser = resultSet.getString(1);
				
				long checkId=resultSet.getLong(1);
				String checkPass = resultSet.getString(2);
				if ((checkId==login.getLoginid())
						&& (checkPass.equals(login.getPassword()))) {
					checkp = true;
				} else {
					checkp = false;
				}
			} else {
				System.out.println("invalid");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return checkp;

	}
	
	
	
	public String checkEmployeeDesgination(Login login) throws SQLException{
		
		String desig="  ";
		
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select dsgn from res_employee where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, login.getLoginid());
		
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			
			desig = resultSet.getString(1);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return desig;
		
		
		
	}
	
}
