package com.iruen.www.test;

import org.json.simple.JSONArray;

public class JsonArrayToString {

	static JSONArray arr = new JSONArray();
	
	public static void main(String[] args){
		String temp = getArr();
		System.out.println(temp);
	}
	
	@SuppressWarnings("unchecked")
	public static String getArr() {
		arr.add("temp");
		arr.add("temp2");
		String temp = arr.toJSONString();
		return temp;
	}
}
