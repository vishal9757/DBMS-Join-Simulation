package com.java.join;

public class JoinData {
	String empId;
	String empName;
	String depId;
	String depName;

	public JoinData(String empId, String empName, String depId, String depName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.depId = depId;
		this.depName = depName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return empId + "-" + empName + "-" + depId + "-" + depName;
	}

}
