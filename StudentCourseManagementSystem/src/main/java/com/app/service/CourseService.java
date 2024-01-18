package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.models.Course;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	
}
