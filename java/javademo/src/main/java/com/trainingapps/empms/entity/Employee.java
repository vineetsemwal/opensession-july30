package com.trainingapps.empms.entity;

public class Employee {
    private long id;
    private String name;
    private int age;
    private Address address;

    public Employee(){}

    public Employee(long id, String name, int age,Address address ){
        this(name,age,address);
        this.id=id;
    }

    public Employee( String name, int age, Address address ){
        this.name = name;
        this.age=age;
        this.address=address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || !obj.getClass().equals(Employee.class) ){
            return false;
        }

        Employee that=(Employee)obj;
        boolean flag=this.id==that.id;
        return flag;
    }
}
