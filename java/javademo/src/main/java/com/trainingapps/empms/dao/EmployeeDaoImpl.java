package com.trainingapps.empms.dao;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.trainingapps.empms.entity.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 1, amit, 21
 * 2, saurav, 22
 */
public class EmployeeDaoImpl implements IEmployeeDao {

    private Map<Long, Employee> store = new HashMap<>();

    public EmployeeDaoImpl() {

        initialize();
    }
/*
    public void initialize() {
        BufferedReader bufferReader = null;

        try {
            Reader reader = new FileReader("/home/vineet/Documents/storage/employeesdata.txt");
            bufferReader = new BufferedReader(reader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String parts[] = line.split(",");
                String idStr=parts[0];
                idStr=idStr.trim();
                long id = Long.parseLong(idStr);
                String name = parts[1];
                name=name.trim();
                String ageStr=parts[2];
                ageStr=ageStr.trim();
                int age = Integer.parseInt(ageStr);
                Employee employee = new Employee(id, name, age);
                save(employee);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
*/



    public void initialize() {
        BufferedReader bufferReader = null;

        try {
            Reader reader = new FileReader("/home/vineet/Documents/storage/employeesdata.json");
             Gson gson = new Gson();
            Employee[]employees=gson.fromJson(reader,Employee[].class);
            for (Employee emp:employees){
                store.put(emp.getId(),emp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    long generatedId;

    long generateId() {
        ++generatedId;
        return generatedId;
    }

    @Override
    public void save(Employee employee) {
        long id = generateId();
        employee.setId(id);
        store.put(id, employee);
    }

    @Override
    public Employee findById(long id) {
        Employee employee = store.get(id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Collection<Employee> values = store.values();
        List<Employee> list = new ArrayList<>(values);
        return list;
    }
}
