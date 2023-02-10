package com.example.demo.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Builder
@Document (collection="User")
public class User {

	


	public User() {
		// TODO Auto-generated constructor stub
	}


	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long id;
	
	
	
	@NotBlank(message="password shouldn't be blank")
	private String password;
	
	
	@Indexed(unique=true)
	@NotBlank(message="username shouldn't be null ")
	private String username;

	
    @Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Indexed(unique=true)
	@Email(message="invalid email")
	private String emailId;
	
	@NotBlank(message="Role should not be blank")
	private String role;
	
	
}
