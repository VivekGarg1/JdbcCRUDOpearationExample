package com.home.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.home.dao.EmployeeDao;
import com.home.dao.impl.EmployeeDaoImpl;
import com.home.model.Employee;
import com.home.util.JdbcUtil;

public class PreparedStatementClientTest {

	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		//createEmployee(employeeDao);
		getAllEmployees(employeeDao);
		//getEmployeeById(employeeDao);
		//updateEmployeeEmailById(employeeDao);
		//deleteEmployeeById(employeeDao);
	}

	private static void getAllEmployees(EmployeeDao employeeDao) {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		allEmployees.forEach(System.out::println);
	}

	private static void getEmployeeById(EmployeeDao employeeDao) {
		int employeeId=4;
		Employee employee = employeeDao.getEmployeeById(4);
		if(employee!=null)
			System.out.println(employee);
		else
			System.out.println("Employee doesn't exist with provided id!!!");
	}

	private static void deleteEmployeeById(EmployeeDao employeeDao) {
		int employeeId=4;
		employeeDao.deleteEmployeeById(employeeId);
	}

	private static void updateEmployeeEmailById(EmployeeDao employeeDao) {
		int employeeId=4;
		String newEmail="ss@gmail.com";
		employeeDao.updateEmployeeEmailById(employeeId, newEmail);
	}

	private static void createEmployee(EmployeeDao employeeDao) {
		Employee employee=new Employee();
		employee.setEmployeeName("Shubham");
		employee.setEmail("s@gmail.com");
		employee.setSalary(17000.0);
		employee.setDateOfJoining(new Date());
		employee.setBonus(new BigDecimal(700));
		employeeDao.createEmployee(employee);
	}

}
