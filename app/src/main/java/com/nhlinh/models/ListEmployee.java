package com.nhlinh.models;

import java.util.ArrayList;

public class ListEmployee {
    private ArrayList<Employee> employees;

    public ListEmployee() {
        employees=new ArrayList<>();
    }

    //truy xuat
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
// setter: thay doi gia tri
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void gen_dataset()
    {
        Employee e1=new Employee();
        e1.setId(1);
        e1.setName("john");
        e1.setEmail("john@gmail.com");
        e1.setPhone("0326439588");
        e1.setUsername("john");
        e1.setPassword("123");
        employees.add(e1);

        Employee e2=new Employee();
        e2.setId(2);
        e2.setName("tom");
        e2.setEmail("tom@gmail.com");
        e2.setPhone("0326439548");
        e2.setUsername("tom");
        e2.setPassword("123");
        employees.add(e2);

        Employee e3=new Employee();
        e3.setId(3);
        e3.setName("peter");
        e3.setEmail("peter@gmail.com");
        e3.setPhone("0326439581");
        e3.setUsername("peter");
        e3.setPassword("123");
        employees.add(e3);
        }
}
