package com.trainingapps.empms.frontend;

import java.util.*;

import com.trainingapps.empms.entity.Address;
import com.trainingapps.empms.entity.Employee;
import com.trainingapps.empms.exceptions.EmployeeNotFoundException;
import com.trainingapps.empms.exceptions.InvalidArgumentsException;
import com.trainingapps.empms.service.EmployeeServiceImpl;
import com.trainingapps.empms.service.IEmployeeService;

public class FrontEnd {
    private IEmployeeService service = new EmployeeServiceImpl();

    public void runUI() {
        try {
/*
            Employee emp1 = service.addEmployee("suyansh", 21);
            System.out.println("*********employee stored");
            display(emp1);

            long emp1Id = emp1.getId();
            Employee emp2 = service.addEmployee("saurav", 22);
            System.out.println("******employee stored");
            display(emp2);
            long emp2Id = emp2.getId();
*/
            long id=2;
            Employee foundEmployee = service.findById(id);
            System.out.println("********found employee for id=" + id);
            display(foundEmployee);

            List<Employee> list = service.findAll();
            System.out.println("*******displaying all employees");
            displayEmployees(list);

        } catch (EmployeeNotFoundException | InvalidArgumentsException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    void display(Employee emp) {
        System.out.println("id-" + emp.getId() + "-name-" + emp.getName() + "-age-" + emp.getAge());
        Address address=emp.getAddress();
        System.out.println("address-"+address.getHouseNumber()+"-"+address.getCity()+"-"+address.getState());
    }
    void displayEmployees(Collection<Employee>employees){
        for (Employee emp:employees){
            display(emp);
        }
    }

}
