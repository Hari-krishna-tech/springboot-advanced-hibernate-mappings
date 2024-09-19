package com.ms.cruddemo.service;

import com.ms.cruddemo.dao.EmployeeRepository;
import com.ms.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
        employeeRepository = theemployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result  = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(result.isPresent()) {
            theEmployee = result.get();
        } else{
            throw new RuntimeException("Can't Find Employee");
        }
        return theEmployee;

    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
