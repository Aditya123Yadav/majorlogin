package com.example.demo.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dto.LoginRequestDto;
import com.example.demo.Dto.LoginResponseDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.Model.Student;

public interface Studentservices {
	
	public Student addStudent(Student student);
	
	public List<Student> getStudents();
	
	
	public Student updateStudent(Student student); 
	
	public Student deleteStudent(long Studentid);
	
	public String uploadImage(String path, MultipartFile file) throws IOException;
	
	InputStream getResource(String path,String fileName) throws FileNotFoundException;
	
	LoginResponseDto loginUser(LoginRequestDto loginResponseDto);
		
}
