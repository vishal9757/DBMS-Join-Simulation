package com.java.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	private List<Row> rows = new ArrayList<>();

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Row row : rows) {
			sb.append(row.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public Map<String, Row> getColToRow(String col) {
		Map<String, Row> map = new HashMap<>();
		for (Row row : rows) {
			String key = row.get(col);
			map.put(key, row);
		}
		return map;
	}

	public void add(Row row) {
		rows.add(row);
	}

	public List<Row> getRows() {
		return rows;
	}

	public static Table innerJoin(Table tab1, Table tab2, String col1, String col2) {
		Map<String, Row> map = tab2.getColToRow(col2);
		Table table = new Table();

		for (Row row : tab1.getRows()) {
			String joincol = row.get(col1);
			Row row2 = map.get(joincol);
			if (row2 != null) {
				Row joinData = new Row(row, row2);
				table.add(joinData);
			}
		}
		return table;
	}
}
