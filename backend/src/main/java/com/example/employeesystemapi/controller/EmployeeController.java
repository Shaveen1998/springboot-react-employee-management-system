package com.example.employeesystemapi.controller;

import com.example.employeesystemapi.model.Employee;
import com.example.employeesystemapi.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") Long id){
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") Long id){
        boolean deleted = false; // Initialize a boolean variable to track whether deletion was successful
        deleted = employeeService.deleteEmployee(id); // Call the service layer to attempt deletion
        Map<String, Boolean> response = new HashMap<>(); // Create a Map to hold the response data
        response.put("deleted", deleted); // Add a key-value pair indicating whether the employee was deleted
        return ResponseEntity.ok(response); // Return a ResponseEntity with the response data and HTTP status OK (200)
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }
}
