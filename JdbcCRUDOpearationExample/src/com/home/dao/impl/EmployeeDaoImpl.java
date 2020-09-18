package com.home.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.home.dao.EmployeeDao;
import com.home.model.Employee;
import com.home.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void createEmployee(Employee employee) {
		String SQLINSERT = "insert into employee_table(employee_name,email,salary,date_of_joining,bonus)"
				+ "values(?,?,?,?,?)";
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQLINSERT)) {
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setDouble(3, employee.getSalary());
			ps.setDate(4, new Date(employee.getDateOfJoining().getTime()));
			ps.setBigDecimal(5, employee.getBonus());
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0)
				System.out.println("Employee created successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<Employee>();
		String SQL = "select * from employee_table";
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employee_Id = rs.getInt("employee_id");
				String employeeName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				Date joiningDate = rs.getDate("date_of_joining");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				Employee employee = new Employee();
				employee.setEmployeeId(employee_Id);
				employee.setEmployeeName(employeeName);
				employee.setEmail(email);
				employee.setSalary(salary);
				employee.setDateOfJoining(joiningDate);
				employee.setBonus(bonus);
				
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = null;
		String SQL = "select * from employee_table where employee_id=?";
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)) {
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int employee_Id = rs.getInt("employee_id");
				String employeeName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				Date joiningDate = rs.getDate("date_of_joining");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				employee = new Employee();
				employee.setEmployeeId(employee_Id);
				employee.setEmployeeName(employeeName);
				employee.setEmail(email);
				employee.setSalary(salary);
				employee.setDateOfJoining(joiningDate);
				employee.setBonus(bonus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(Integer employeeId, String newEmail) {
		String SQLUPDATE = "update employee_table set email=? where employee_id=?";
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQLUPDATE)) {
			ps.setString(1, newEmail);
			ps.setInt(2, employeeId);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0)
				System.out.println("Employee updated successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		String SQLDELETE = "delete from employee_table where employee_id=?";
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQLDELETE)) {
			ps.setInt(1, employeeId);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0)
				System.out.println("Employee deleted successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
