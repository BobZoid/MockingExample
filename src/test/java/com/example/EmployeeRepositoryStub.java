package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository{
    @Override
    public List<Employee> findAll() {
        List<Employee> dummyList = new ArrayList<>();
        dummyList.add(new Employee("a", 10));
        dummyList.add(new Employee("b", 20));
        dummyList.add(new Employee("c", 5));
        return dummyList;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
