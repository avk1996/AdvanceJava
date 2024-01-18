package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService{

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getAllStudents(){
		return studentDao.findAll();
	}
	
	public Student insertStudent(Student student) {
		return studentDao.save(student);
	}

}
