package com.foodUtilitySystem.KhaanaBachaoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="foodsaver")
public class FoodSavers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	@Column(name="first_name")
	private String fname;
	@Column(name="last_name")
	private String lname;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String uname;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public FoodSavers() {
		
	}


	public FoodSavers(String fname, String lname, String email, String uname, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.uname = uname;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "FoodSavers [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", uname="
				+ uname + ", password=" + password + ", role=" + role + "]";
	}


	
	
	
}
