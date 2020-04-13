package com.example.demo;

import java.io.Serializable;

public class Student implements Serializable  {

	private Integer id;
	private String name;
	private String email;
	private boolean genius;
	
	public Student() {
		super();
	}
	public Student(Integer id, String name, String email, boolean genius) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.genius = genius;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGenius() {
		return genius;
	}
	public void setGenius(boolean genius) {
		this.genius = genius;
	}

}
