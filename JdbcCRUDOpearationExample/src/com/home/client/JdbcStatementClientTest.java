package com.home.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.home.util.JdbcUtil;

public class JdbcStatementClientTest {

	public static void main(String[] args) {
		//createEmployee();
		getAllEmployees();
		//getEmployeeById();
		//updateEmployeeEmailById();
		//deleteEmployeeById();
	}

	private static void getAllEmployees() {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			String SQL="select * from employee_table";	
			ResultSet rs = statement.executeQuery(SQL);
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name=rs.getString("employee_name");
				String email=rs.getString("email");
				Double salary=rs.getDouble("salary");
				Date joiningDate=rs.getDate("date_of_joining");
				BigDecimal bonus=rs.getBigDecimal("bonus");
				System.out.println("EmployeeId: "+employee_id);
				System.out.println("Employee name: "+employee_name);
				System.out.println("Email: "+email);
				System.out.println("Employee joining date: "+joiningDate);
				System.out.println("Bonus: "+bonus);
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getEmployeeById() {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			String SQL="select * from employee_table where employee_id=1";	
			ResultSet rs = statement.executeQuery(SQL);
			if(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name=rs.getString("employee_name");
				String email=rs.getString("email");
				Double salary=rs.getDouble("salary");
				Date joiningDate=rs.getDate("date_of_joining");
				BigDecimal bonus=rs.getBigDecimal("bonus");
				System.out.println("EmployeeId: "+employee_id);
				System.out.println("Employee name: "+employee_name);
				System.out.println("Email: "+email);
				System.out.println("Employee joining date: "+joiningDate);
				System.out.println("Bonus: "+bonus);
			}
			else
				System.out.println("Employee doesn't exist with provded Id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteEmployeeById() {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			String SQLUPDATE="delete from employee_table where employee_id=2";	
			int executeUpdate = statement.executeUpdate(SQLUPDATE);
			if(executeUpdate>0)
				System.out.println("Employee deleted successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateEmployeeEmailById() {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			String SQLUPDATE="update employee_table set email='ps@gmail.com' where employee_id=2";	
			int executeUpdate = statement.executeUpdate(SQLUPDATE);
			if(executeUpdate>0)
				System.out.println("Employee email updated successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createEmployee() {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			String SQLINSERT="insert into employee_table(employee_name,email,salary,date_of_joining,bonus)"
					+ "values('Prabhat','p@gmail.com',16000.0,'2017-03-26',500.0)";	
			int executeUpdate = statement.executeUpdate(SQLINSERT);
			if(executeUpdate>0)
				System.out.println("Employee created successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
