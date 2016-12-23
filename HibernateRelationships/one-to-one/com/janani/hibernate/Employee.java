package com.janani.hibernate;

public class Employee {

	private int empno;
	private String username;
	private Person personalDetails;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Person getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(Person personalDetails) {
		this.personalDetails = personalDetails;
	}

}
