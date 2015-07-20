package com.iruen.www.json.gson;

import java.util.List;
import java.util.ArrayList;

public class Company {

	private String name;
	private List<Person> employees;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public List<Person> getEmployees() {return employees;}
	public void setEmployees(List<Person> employees) {this.employees = employees;}

	public static class Person{
		private String name;
		private String age;
		private String sex;
		
		public Person(){}
		
		public Person(String name, String age, String sex) {
			super();
			this.name = name;
			this.age = age;
			this.sex = sex;
		}
		
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		public String getAge() {return age;}
		public void setAge(String age) {this.age = age;}
		public String getSex() {return sex;}
		public void setSex(String sex) {this.sex = sex;}
	}
	
	public static Company getCommpanyDummy() {
		Company company = new Company();
		company.setName("skyfly33 1person development!");
		List<Company.Person> personList = new ArrayList<Person>();
		
		Person p1 = new Person("ÀÌµ¿ÈÆ","30","male");
		personList.add(p1);
		Person p2 = new Person("¾çÇöÁ¾","27","male");
		personList.add(p2);
		Person p3 = new Person();
		p3.setName("Å©¸®½ºÅ»");
		p3.setSex("female");
		personList.add(p3);
		
		company.setEmployees(personList);
		
		return company;
	}
}
