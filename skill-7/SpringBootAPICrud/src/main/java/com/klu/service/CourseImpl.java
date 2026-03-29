package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.repo.CourseRepo;

@Service
public class CourseImpl implements CourseService{
	@Autowired
	private CourseRepo courseRepo;
	

	@Override
	public Course saveCourse(Course c) {
		return courseRepo.save(c);
	}

	@Override
	public List<Course> getByCourse() {
		return courseRepo.findAll();
	}

	@Override
	public Course updateCourse(Long id, Course c) {
		// TODO Auto-generated method stub
		Course cor=courseRepo.findById(id).orElseThrow();
		cor.setTittle(c.getTittle());
		cor.setDuration(c.getDuration());
		cor.setFee(c.getFee());
		return 	courseRepo.save(cor);
	}

	@Override
	public String deleteCourse(Long id) {
		// TODO Auto-generated method stub
		Course c=courseRepo.findById(id).orElseThrow();
				courseRepo.deleteById(id);
		return "sucessfully deleted";
	}

}
