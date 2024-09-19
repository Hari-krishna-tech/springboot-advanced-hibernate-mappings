package com.ms.cruddemo.rest;

import com.ms.cruddemo.entity.Employee;
import com.ms.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Inject employee DAO directly
    private EmployeeService employeeService;

    @Autowired
    public  EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" endpoint
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee) {

        return employeeService.save(theEmployee);

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.ok("employee deleted");
    }

}
