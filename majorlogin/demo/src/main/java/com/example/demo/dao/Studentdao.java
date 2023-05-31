 package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Student;



public interface Studentdao extends JpaRepository<Student, Long > {
	 
	@Query(value = "select u from Student u where u.UserName = :userName")
    Optional<Student> findByUserName(String userName);

}
