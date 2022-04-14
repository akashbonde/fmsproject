package com.fmsproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmsproject.entity.Course;
import com.fmsproject.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> viewAllCourses() {

		List<Course> courses = courseService.viewAllCourses();
		return courses;
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
		Course courseReturn = courseService.addCourse(course);

		if (courseReturn.equals(null)) {
			return new ResponseEntity("Sorry!Course not inserted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
}
