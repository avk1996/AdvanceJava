package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDto;
import com.app.models.Course;
import com.app.models.Student;
import com.app.service.CourseService;
import com.app.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping
	public void insertStudent(@RequestBody StudentDto studentDto) {
		studentService.insertStudent(studentDto);
	}

}
