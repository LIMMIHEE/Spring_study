package com.example.demo;

import java.io.Serializable;

public class Author implements Serializable{
	 private String name;
	    public Author() { super(); }
	    public Author(String name) {        super();        this.name = name;    }
	    public String getName() {        return name;    }    
	    public void setName(String name) {        this.name = name;    } 
}
