package com.klu.service;

import java.util.List;

import com.klu.model.Course;

public interface CourseService {
	Course saveCourse(Course c);
	List<Course> getByCourse();
	Course updateCourse(Long id,Course c);
	String deleteCourse(Long id);
}
