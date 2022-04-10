package com.fmsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.CourseRepository;
import com.fmsproject.entity.Course;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
		courseRepository.saveAndFlush(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course removeCourse(int courseId) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(courseId);
		return null;
	}

	@Override
	public Course viewCourse(int courseId) {
		// TODO Auto-generated method stub
		
		Optional<Course> course = courseRepository.findById(courseId);

		if (!course.isPresent()) {
			System.out.println("No course found for the given ID!!");
		}

		return course.get();
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		
		List<Course> allCourses = courseRepository.findAll();

		if (allCourses.isEmpty()) {
			System.out.println("No courses found!!");
		}

		return allCourses;
	}
	
}
