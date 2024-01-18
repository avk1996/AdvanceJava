package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Student;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}

}
