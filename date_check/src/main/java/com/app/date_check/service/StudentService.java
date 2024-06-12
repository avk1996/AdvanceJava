package com.app.date_check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.date_check.entity.Student;
import com.app.date_check.repository.StudentRepository;
import com.app.date_check.service.exception.GlobalStudentException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) throws GlobalStudentException {
		System.out.println(student.toString());

		// 1. avoid duplication of students with same id
		Student existingStudent = studentRepository.findByStudentCode(student.getStudentCode());
//		System.out.println(existingStudent == null ? "student not exists" : "student not exists");
		if (existingStudent != null)
			throw new GlobalStudentException("Student already exists\nSUGGESTION: Add new student code");

		// 2. check for null values
		if (student.getName() == null)
			throw new GlobalStudentException("Student name can't be empty");
		if (student.getDepartment() == null)
			throw new GlobalStudentException("Student department can't be empty");
		if (student.getDateOfBirth() == null)
			throw new GlobalStudentException("Student date of birth can't be empty");

		// 3. save the data
		return studentRepository.save(student);
	}

	public List<Student> showStudents() {
		return studentRepository.findAll();
	}

}
