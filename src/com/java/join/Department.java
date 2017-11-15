package com.java.join;

public class Department {
	String id;
	String name;

	public Department(String str) {
		String[] depData = str.split(",");
		this.id = depData[0];
		this.name = depData[1];
	}
	

}
