package com.example.employeesystemapi.services;

import com.example.employeesystemapi.model.Employee;


import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);


    boolean deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee getEmployeeById(Long id);
}
