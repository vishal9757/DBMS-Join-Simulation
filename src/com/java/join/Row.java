package com.java.join;

import java.util.HashMap;
import java.util.Map;

public class Row {
	private Map<String, String> record = new HashMap<>();

	public Row(String[] header, String[] values) {
		for (int i = 0; i < values.length; i++) {
			record.put(header[i], values[i]);
		}
	}

	public Row() {
		super();
	}

	public Row(Row... rows) {
		for (Row row : rows) {
			record.putAll(row.record);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> e : record.entrySet()) {
			sb.append((e.getKey() + "->" + e.getValue() + "|"));
		}
		return sb.substring(0, sb.length() - 1);
	}

	public void putAll(Row row) {
		record.putAll(row.record);
	}

	public String get(String col) {
		return record.get(col);
	}

}
