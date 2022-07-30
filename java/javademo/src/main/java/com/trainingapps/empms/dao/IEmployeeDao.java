package com.trainingapps.empms.dao;

import java.util.List;
import com.trainingapps.empms.entity.Employee;

public interface IEmployeeDao {

    void save(Employee employee);

    Employee findById(long id);

    List<Employee> findAll();

}
