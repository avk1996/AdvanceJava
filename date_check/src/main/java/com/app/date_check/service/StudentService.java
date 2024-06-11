package com.app.date_check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.date_check.entity.Student;
import com.app.date_check.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		System.out.println(student.toString());
		return studentRepository.save(student);
	}

	public List<Student> showStudents() {
		return studentRepository.findAll();
	}

}
