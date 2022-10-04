package com.voterapp.main;

public class Voter {
	
	int age;
	int id;
	String locality;
	public Voter(int age, int id, String locality) {
		super();
		this.age = age;
		this.id = id;
		this.locality = locality;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	@Override
	public String toString() {
		return "Voter [age=" + age + ", id=" + id + ", locality=" + locality + "]";
	}
	
	
    	
}
