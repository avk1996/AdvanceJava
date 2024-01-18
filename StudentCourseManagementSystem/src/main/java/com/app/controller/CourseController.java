package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Course;
import com.app.models.Student;
import com.app.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
//	@GetMapping("/{courseName}")
//	public List<Student> getStudentsByCourse(@PathVariable String courseName) {
//		return courseService.getStudentsByCourse(courseName);
//	}
//	
//	@GetMapping("/{courseId}")
//	public List<Student> getStudentsByCourseId(@PathVariable int courseId){
//		return courseService.getStudentsByCourseId(courseId);
//	}
}
