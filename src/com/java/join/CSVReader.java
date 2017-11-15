package com.java.join;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {

	private static List<String> read(String str) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(str));
		List<String> list = new ArrayList<>();
		try {
			String s = "";
			br.readLine();
			while ((s = br.readLine()) != null) {
				list.add(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return list;
	}

	public static Table readCustomFile(String str) throws IOException {
		Table table = new Table();
		BufferedReader br = new BufferedReader(new FileReader(str));

		try {
			String s = br.readLine();
			String[] atrributes = s.split(",");
			while ((s = br.readLine()) != null) {
				String[] row = s.split(",");
				if (row.length != atrributes.length) {
					continue;
				}
				table.add(new Row(atrributes, row));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return table;
	}

	public static List<Employee> readEmp(String str) throws IOException {
		List<Employee> list = new ArrayList<>();
		for (String employee : read(str)) {
			list.add(new Employee(employee));
		}
		return list;
	}

	public static List<Department> readDept(String str) throws IOException {
		List<Department> list = new ArrayList<>();
		for (String dept : read(str)) {
			list.add(new Department(dept));
		}
		return list;
	}

	public List<JoinData> innerJoin(List<Employee> employee, List<Department> department) {
		List<JoinData> joinData = new ArrayList<>();
		Map<String, Department> map = new HashMap<>();
		for (Department d : department) {
			map.put(d.id, d);
		}
		for (Employee e : employee) {
			Department d = map.get(e.deptId);
			if (d != null) {
				joinData.add(new JoinData(e.id, e.name, e.deptId, d.name));
			}
		}
		return joinData;
	}

	public void printList(List<JoinData> list) {
		System.out.println("empId-empName-depId-depName");
		for (JoinData string : list) {
			System.out.println(string);
		}

	}



}
