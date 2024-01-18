package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.dto.StudentDto;
import com.app.models.Course;
import com.app.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseService courseService;

	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	public void insertStudent(StudentDto studentDto) {

		int courseId = studentDto.getCourseId();
		Student student = new Student();
		Course course = courseService.getCourseById(courseId);
		
		List<Course> courses = courseService.getAllCourses();
		
		for (Course courseList : courses) {
			if (courseId == courseList.getId()) 
			{
				if (student.getScore() >= course.getMinScore()) 
				{
					student.setFirstName(studentDto.getFirstName());
					student.setLastName(studentDto.getLastName());
					student.setScore(studentDto.getScore());
					student.setEmail(studentDto.getEmail());
					student.setCourse(course);
					
					studentDao.save(student);
				} 
				else 
				{
					throw new RuntimeException("Not eligible for this course");
				}
			} 
			else 
			{
				throw new RuntimeException("Given course does not exits!");
			}
		}		
		
		
	}

}
