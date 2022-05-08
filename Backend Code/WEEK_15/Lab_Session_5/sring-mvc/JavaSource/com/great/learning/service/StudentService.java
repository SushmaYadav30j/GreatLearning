package com.great.learning.service;

import java.util.List;

import com.great.learning.entity.Student;

public interface StudentService {
	
	void saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudent(int id);

	void deleteStudent(int id);

}
