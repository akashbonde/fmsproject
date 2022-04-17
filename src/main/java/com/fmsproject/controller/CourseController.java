package com.fmsproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		return new ResponseEntity<Course>(courseReturn, HttpStatus.OK);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> viewCourseById(@Valid @PathVariable("courseId") int courseId) {

		Course course = courseService.viewCourse(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);

	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Course> removeCourse(@Valid @PathVariable("courseId") Integer courseId) {
		courseService.removeCourse(courseId);
		
		return new ResponseEntity("The course is deleted! ", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course) {
		Course resultCourse = courseService.updateCourse(course);
		
		return new ResponseEntity<Course>(resultCourse, HttpStatus.OK);
	}
}
