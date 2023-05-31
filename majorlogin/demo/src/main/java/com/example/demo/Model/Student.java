package com.example.demo.Model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Studentid;
	private String StudentName;
	private String Interests;
	private String Skills;
	private String Bio;
	private int Year;
	private String Branch;
	private String Photos;
	private String UserName;
	private String Password;
	private String role;
	
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Student [Studentid=" + Studentid + ", StudentName=" + StudentName + ", Interests=" + Interests + ", Skills="
				+ Skills + ", Bio=" + Bio + ", Year=" + Year + ", Branch=" + Branch + ",Photos=" +Photos +" , UserName="+ UserName+""
						     + " , Password=" +Password+"]";
		
	}


	public Long getStudentid() {  
		return Studentid;
	}


	public void setStudentid(Long studentid) {
		Studentid = studentid;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public String getInterests() {
		return Interests;
	}


	public void setInterests(String interests) {
		Interests = interests;
	}


	public String getSkills() {
		return Skills;
	}


	public void setSkills(String skills) {
		Skills = skills;
	}


	public String getBio() {
		return Bio;
	}


	public void setBio(String bio) {
		Bio = bio;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	public String getBranch() {
		return Branch;
	}


	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getUserName() {
		return UserName;
		
	}

	public void setUserName (String userName) {
		UserName = userName;
		
	}
	
	public String getPassword() {
		return Password;
		
	}
	
	public void setPassword(String password) {
		Password = password;
		
	}
	
	public Student(Long studentid, String studentName, String interests, String skills, String bio, int year,
			String branch,String photos, String userName, String password) {
		super();
		Studentid = studentid;
		StudentName = studentName;
		Interests = interests;
		Skills = skills;
		Bio = bio;
		Year = year;
		Branch = branch;
		Photos=photos;
		UserName= userName;
		Password = password;
		
	}


	public Student() {
		super();
		
	}


	public String getPhotos() {
		return Photos;
	}


	public void setPhotos(String photos) {
		Photos = photos;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		return Arrays.asList(authority);
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return UserName;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
