package com.trainingapps.empms.service;

import com.trainingapps.empms.dao.EmployeeDaoImpl;
import com.trainingapps.empms.dao.IEmployeeDao;
import com.trainingapps.empms.entity.Address;
import com.trainingapps.empms.entity.Employee;
import com.trainingapps.empms.exceptions.EmployeeNotFoundException;
import com.trainingapps.empms.exceptions.InvalidArgumentsException;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService{
   private IEmployeeDao dao=new EmployeeDaoImpl();

    @Override // metadata
    public Employee addEmployee(String name, int age, String houseNumber, String city, String state) throws InvalidArgumentsException{
        validateName(name);
        validateAge(age);
        Address address=new Address(houseNumber,city,state);
        Employee employee=new Employee(name,age,address);
        dao.save(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee>list=dao.findAll();
        return list;
    }

    @Override
    public Employee findById(long id) throws EmployeeNotFoundException,InvalidArgumentsException{
        validateId(id);
        Employee employee=dao.findById(id);
        if(employee==null){
            throw new EmployeeNotFoundException("employee not found for id="+id);
        }
        return employee;
    }

    void validateName(String name) throws InvalidArgumentsException{
        if(name==null ||name.isEmpty()){
            throw new InvalidArgumentsException("name can't be null or empty");
        }
    }

    void validateAge(int age)throws InvalidArgumentsException{
        if(age<18 || age>60){
            throw new InvalidArgumentsException("age not between 18 and 60");
        }
    }

    void validateId(long id)throws InvalidArgumentsException{
        if(id<=0){
            throw new InvalidArgumentsException("id cant' be less than 1");
        }

    }

}
