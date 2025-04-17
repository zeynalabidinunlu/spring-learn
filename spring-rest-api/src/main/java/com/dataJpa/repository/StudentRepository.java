package com.dataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataJpa.entites.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	
	
	
	
}
