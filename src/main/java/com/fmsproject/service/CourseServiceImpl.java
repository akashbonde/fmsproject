package com.fmsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.CourseRepository;
import com.fmsproject.entity.Course;
import com.fmsproject.exception.NullValueFoundException;

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
		
		try {
			courseRepository.save(course);
		}
		catch(Exception e) {
			throw new NullValueFoundException("The course with given ID is not present in the database!");
		}
		
		return course;
	}

	@Override
	public Course removeCourse(int courseId) {
		// TODO Auto-generated method stub
		try {
			courseRepository.deleteById(courseId);
		}
		catch(Exception e) {
			throw new NullValueFoundException("No course with given ID present in the database");
		}
		
		return null;
	}

	@Override
	public Course viewCourse(int courseId) {
		// TODO Auto-generated method stub
		
		Optional<Course> course = courseRepository.findById(courseId);

		if (!course.isPresent()) {
			throw new NullValueFoundException("No course with given ID present in the database");
		}

		return course.get();
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		
		List<Course> allCourses = courseRepository.findAll();

		if (allCourses.isEmpty()) {
			throw new NullValueFoundException("No courses present in the database");
		}

		return allCourses;
	}
	
}
