package com.app.date_check.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.date_check.entity.Student;
import com.app.date_check.service.StudentService;
import com.app.date_check.service.exception.ErrorDetails;
import com.app.date_check.service.exception.GlobalStudentException;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create_student")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		try {
			Student newStudent = studentService.addStudent(student);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(newStudent);
		} catch (GlobalStudentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
		}
	}

	@GetMapping("/show_students")
	public List<Student> showStudents() {
		return studentService.showStudents();
	}
}
