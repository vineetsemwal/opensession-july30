package com.trainingapps.empms.service;

import java.util.*;
import com.trainingapps.empms.entity.Employee;
import com.trainingapps.empms.exceptions.EmployeeNotFoundException;
import com.trainingapps.empms.exceptions.InvalidArgumentsException;

public interface IEmployeeService {

    Employee  addEmployee(String name, int age,String houseNumber, String city, String state) throws InvalidArgumentsException;

    List<Employee>findAll();

    Employee findById(long id) throws EmployeeNotFoundException,InvalidArgumentsException;

}
