package com.java.join;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// List<Employee> employee = csv.readEmp("employee.txt");
		// List<Department> department = csv.readDept("department.txt");

		Table empTable = CSVReader.readCustomFile("employee.txt");
		Table depTable = CSVReader.readCustomFile("department.txt");

		Table innerJoin = Table.innerJoin(empTable, depTable, "emp_Id", "emp_Id");

		System.out.println("-");

		System.out.println(innerJoin);

		// List<JoinData> innerJoin = csv.innerJoin(employee, department);

		// printList(innerJoin);

	}

}
