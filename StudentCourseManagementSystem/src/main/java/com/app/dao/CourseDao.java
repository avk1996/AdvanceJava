package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.Course;
import com.app.models.Student;

public interface CourseDao extends JpaRepository<Course, Integer>{

//	List<Student> findByCourseTitle(String courseName);
	Course findById(int courseId);
}
