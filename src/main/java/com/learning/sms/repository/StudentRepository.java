package com.learning.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
