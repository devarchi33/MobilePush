package com.iruen.www.json.simple;

import java.util.ArrayList;

import org.json.simple.JSONArray;

public class JsonArray {

	public ArrayList<String> creatList() {
		ArrayList<String> list = new ArrayList<String>();

		list.add("mongodb");
		list.add("mysql");
		list.add("casandra");
		list.add("redis");

		return list;
	}

	@SuppressWarnings("unchecked")
	public JSONArray createJsonArray() {
		JSONArray jsonArr = new JSONArray();

		jsonArr.add("jsonArr_mongodb");
		jsonArr.add("jsonArr_mysql");
		jsonArr.add("jsonArr_redis");

		return jsonArr;
	}
}
