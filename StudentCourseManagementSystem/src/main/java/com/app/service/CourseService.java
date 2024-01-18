package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.models.Course;
import com.app.models.Student;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getAllCourses() {
		return courseDao.findAll();
	}
	public Course addCourse(Course course) {
		return courseDao.save(course); 
	}
//	public List<Student> getStudentsByCourse(String courseName) {
//		return courseDao.findByCourseTitle(courseName);
//	}
//	public List<Student> getStudentsByCourseId(int courseId){
//		return courseDao.findById(courseId);
//	}
//	
	public Course getCourseById(int courseId) {
		return courseDao.findById(courseId);
	}
}
