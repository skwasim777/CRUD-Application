package com.spring.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.service.EmpService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/emp")
public class EmpController {
	@Autowired
	private EmpService empService;

	// build create Emp REST API
	@PostMapping
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
		Employee savedUser = empService.createEmp(emp);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get Emp by id REST API
	// http://localhost:8080/api/emp/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long eId) {
		Employee user = empService.getEmpById(eId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// Build Get All Emp REST API
	// http://localhost:8080/api/emp
	@GetMapping
	public ResponseEntity<ArrayList<Employee>> getAllEmp() {
		ArrayList<Employee> emp = (ArrayList<Employee>) empService.getAllEmp();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// Build Update Emp REST API
	@PutMapping("{id}")
	// http://localhost:8080/api/emp/1
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") Long eId, @RequestBody Employee emp) {
		emp.setEid(eId);
		Employee updatedUser = empService.updateEmp(emp);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Build Delete Emp REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Long eId) {
		empService.deleteEmp(eId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
