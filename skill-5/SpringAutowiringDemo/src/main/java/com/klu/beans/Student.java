package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class Student {
	private long sid;
	private  String name;
	private String gender;
	@Autowired
	private Certification certification;
	public Long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Certification getCertification() {
		return certification;
	}
	public void setCertification(Certification certification) {
		this.certification = certification;
	}
	public void sdisplay() {
		System.out.println("Sid:"+sid);
		System.out.println("name:"+name);
		System.out.println("gender:"+gender);
		certification.display();
	}
}
