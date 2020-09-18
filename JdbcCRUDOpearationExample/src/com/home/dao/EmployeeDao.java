package com.home.dao;

import java.util.List;

import com.home.model.Employee;

public interface EmployeeDao {
	
	public abstract void createEmployee(Employee employee);
	public abstract List<Employee> getAllEmployees();
	public abstract Employee getEmployeeById(Integer employeeId);
	public abstract void updateEmployeeEmailById(Integer employeeId,String newEmail);
	public abstract void deleteEmployeeById(Integer employeeId);

}
