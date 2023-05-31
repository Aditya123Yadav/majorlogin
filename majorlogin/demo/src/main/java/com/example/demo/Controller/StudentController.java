package com.example.demo.Controller;


import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dto.LoginRequestDto;
import com.example.demo.Dto.LoginResponseDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.Model.Student;
import com.example.demo.payload.FileResponse;
import com.example.demo.services.Studentservices;

import jakarta.servlet.http.HttpServletResponse;

@RestController

@CrossOrigin
public class StudentController {
	
	@Autowired
	private Studentservices studentservices;
	
	
	
	public FileResponse fileresponse;
	
	@PostMapping("/Student")
	
	public Student addStudent(@RequestBody Student student) {
		return this.studentservices.addStudent(student);
	}
		
	@GetMapping("/students")
	
		public List<Student> getStudents() {
		return this.studentservices.getStudents();
		
	}
	
	@PutMapping("/Edit")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentservices.updateStudent(student);
	}
	
	@DeleteMapping("/Student/{Studentid}")
		public Student deleteStudent(@PathVariable String Studentid) {
			return this.studentservices.deleteStudent(Long.parseLong (Studentid));
			
			
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser( @RequestBody LoginRequestDto loginRequest){
        LoginResponseDto response = new LoginResponseDto ();
		try{
			response = this.studentservices.loginUser(loginRequest);

		}catch(Exception ex){
            response.setStatus(false);
			response.setMessage("Exception while login");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(
			@RequestParam("image") MultipartFile image){
		String fileName =null;
		try {
		String fileName1= this.studentservices.uploadImage(path, image);
		} catch (IOException e) {
			e.printStackTrace();
			
		   return new ResponseEntity<>(new FileResponse(fileName ), HttpStatus.ACCEPTED);
			
		}
		return new ResponseEntity<>(new FileResponse(fileName ,path), HttpStatus.OK);
		
		
	}
	@GetMapping("/images/{imageName}")
	
	public void getResource(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response )

	
	throws IOException {System.out.println("aaa");
		
		InputStream resourse =this.studentservices.getResource(path, imageName);
		response.setContentType(imageName);
		StreamUtils.copy(resourse,response.getOutputStream());
		
	}
	
		
	}

	



