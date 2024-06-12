package com.app.date_check.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.date_check.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Student findByStudentCode(int studentCode);
}
