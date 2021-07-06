package com.learning.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learning.sms.entity.Student;
import com.learning.sms.service.StudentService;

@Controller
@RequestMapping("/sms/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("students")
	public ModelAndView viewStudentList(ModelAndView modelAndView) {
		modelAndView.addObject("students", studentService.getStudentList());
		modelAndView.setViewName("student_view");
		return modelAndView;
	}

	@PostMapping("addStudent")
	public ModelAndView createStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return new ModelAndView("redirect:students");
//		return "redirect:sms/students";
	}

	@GetMapping("createNew")
	public ModelAndView createNew(ModelAndView modelAndView) {
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("create_view");
		return modelAndView;
	}

	@GetMapping("updateView/{id}")
	public ModelAndView updateView(@PathVariable(name = "id") long id, ModelAndView modelAndView) {
		modelAndView.addObject("student", studentService.getStudentbyId(id));
		modelAndView.setViewName("update_view");
		return modelAndView;
	}

	@PostMapping("updateStudent")
	public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
		studentService.updateStudent(student);
		return new ModelAndView("redirect:students");
	}

	@GetMapping("deleteStudent/{id}")
	public ModelAndView deleteStudent(@PathVariable(name = "id") long id) {
		studentService.deleteStudent(id);
		return new ModelAndView("redirect:/sms/students");
	}
}
