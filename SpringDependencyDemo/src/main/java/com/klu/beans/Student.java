package com.klu.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private Long sid;
	private String sname;
	private String course;
	private String academicyear;
	public Student(Long sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAcademicyear() {
		return academicyear;
	}
	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}
	public void display() {
		System.out.println("studentId:"+sid);
		System.out.println("StudentName:"+sname);
		System.out.println("Course:"+course);
		System.out.println("AcademicYear:"+academicyear);
	}
}
