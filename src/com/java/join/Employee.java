package com.java.join;

public class Employee {
	String id;
	String name;
	String deptId;

	public Employee(String str) {
		String[] empData = str.split(",");
		this.id = empData[0];
		this.name = empData[1];
		this.deptId = empData[2];
	}

}
