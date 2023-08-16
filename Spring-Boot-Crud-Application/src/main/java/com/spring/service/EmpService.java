package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.entity.Employee;

public interface EmpService {
	Employee createEmp(Employee emp);

    Employee getEmpById(Long eId);

    ArrayList<Employee> getAllEmp();

    Employee updateEmp(Employee emp);

    void deleteEmp(Long eId);
}
