package com.iruen.www.json.gson;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {

	public static void main(String[] args) {
		Company company = Company.getCommpanyDummy();

		System.out.println("======= Object => Json =======");
		String company2JSon = new Gson().toJson(company);
		System.out.println(company2JSon);

		System.out.println("======= Json => Object =======");
		Company json2Company = new Gson().fromJson(company2JSon, Company.class);
		printCompanyObject(json2Company);

		System.out.println("======= Object => Json =======");
		String company2JSonIsNull = new GsonBuilder().serializeNulls().create().toJson(company);
		System.out.println(company2JSonIsNull);

		System.out.println("======= Json => Object =======");
		Company json2CompanyIsNull = new Gson().fromJson(company2JSonIsNull, Company.class);
		printCompanyObject(json2CompanyIsNull);
	}
	
	private static void printCompanyObject(Company company) {
		List<Company.Person> personLsit = company.getEmployees();
		System.out.println("Company Name : " + company.getName());
		
		for (Company.Person person : personLsit) {
			System.out.println("Name : " + person.getName());
			System.out.println("Age : " + person.getAge());
			System.out.println("Sex : " + person.getSex());
		}
	}
}
