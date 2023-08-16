package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Employee;

public interface Emprepository extends JpaRepository<Employee,Long>{

}
