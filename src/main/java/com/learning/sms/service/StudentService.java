package com.learning.sms.service;

import java.util.List;

import com.learning.sms.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getStudentList();
	Student getStudentbyId(long id);

	Student updateStudent(Student student);

	String deleteStudent(long id);

}
