package com.iruen.www.json.simple;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class JsonObject {

	@SuppressWarnings("unchecked")
	public JSONObject createJsonObj() {
		JSONObject obj = new JSONObject();
		obj.put("json_nosql_db", "mongodb");
		obj.put("json_rdb", "mysql");
		return obj;
	}

	public HashMap<String, String> createMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("map_nosql_db", "mongodb");
		map.put("map_rdb", "mysql");

		return map;
	}
}
