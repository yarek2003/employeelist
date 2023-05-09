package com.example.lists.service;

import com.example.lists.Employee;
import com.example.lists.exeptions.EmployeeAlreadyAddedException;
import com.example.lists.exeptions.EmployeeNotFoundException;
import com.example.lists.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public static final int MAX_SIZE = 10;
    private final List<Employee> employees = new ArrayList<>(MAX_SIZE);

    public Employee add (String firstName, String lastName){
        if (employees.size()>MAX_SIZE){
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    public Employee del (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
    return employee;
    }
}
