package com.learning.sms.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.learning.sms.entity.Student;
import com.learning.sms.exception.StudentNoDataFoundException;
import com.learning.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> studentList=studentRepository.findAll();
		studentList= CollectionUtils.isEmpty(studentList) ? Arrays.asList(new Student()):studentList;
		return studentList;
	}

	@Override
	public Student getStudentbyId(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNoDataFoundException(id));
	}

	@Override
	public Student updateStudent(Student student) {
		getStudentbyId(student.getId());
		return saveStudent(student);

	}

	@Override
	public String deleteStudent(long id) {
		getStudentbyId(id);
		studentRepository.deleteById(id);
		return String.format("Student with id : %o deleted sucessfully", id);
	}

}
