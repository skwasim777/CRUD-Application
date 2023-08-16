package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Employee;
import com.spring.repository.Emprepository;
import com.spring.service.EmpService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {
	@Autowired
	private Emprepository empRepository;

	@Override
	public Employee createEmp(Employee emp) {
		return empRepository.save(emp);
	}

	 @Override
    public Employee getEmpById(Long eId) {
        Optional<Employee> optionalUser = empRepository.findById(eId);
        return optionalUser.get();
    }

	@Override
	public ArrayList<Employee> getAllEmp() {
		return (ArrayList<Employee>) empRepository.findAll();
	}

	@Override
	public Employee updateEmp(Employee emp) {
		Employee existingEmp = empRepository.findById(emp.getEid()).get();
		existingEmp.seteName(emp.geteName());
		existingEmp.seteAddr(emp.geteAddr());
		existingEmp.seteAddr(emp.geteAddr());
		existingEmp.seteEmail(emp.geteEmail());
		Employee updatedUser = empRepository.save(existingEmp);
		return updatedUser;
	}

	@Override
	public void deleteEmp(Long eId) {
		empRepository.deleteById(eId);
	}
}
