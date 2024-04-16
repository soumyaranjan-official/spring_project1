package com.org.spring_project1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.spring_project1.dto.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> 
{
	List<Teacher> findByEmailAndPassword(String email, String password);
	List<Teacher> findByNameAndPassword(String name , String password);
//
//	@Query("SELECT t FROM Teacher t WHERE salary>=?1")
//	List<Teacher> findByGreaterSalary(int salary);
//	
//	@Query("SELECT t FROM Teacher t WHERE experience>=?1")
//	List<Teacher> findByExperience(int experience);
}
