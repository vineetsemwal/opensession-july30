package com.trainingapps.empms;

public class Employee {
    private long id;
    private String name;
    private int age;

    public Employee(long id, String name, int age ){
        this.id=id;
        this.name = name;
        this.age=age;
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

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }

        if(obj==null || !(obj instanceof Employee) ){
            return false;
        }

        Employee that=(Employee)obj;
        boolean flag=this.id==that.id;
        return flag;
    }
}
