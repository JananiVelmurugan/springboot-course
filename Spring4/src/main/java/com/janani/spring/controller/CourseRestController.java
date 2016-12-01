package com.janani.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janani.spring.dao.CourseDAO;

@CrossOrigin
@RestController
public class CourseRestController {

	@Autowired
	private CourseDAO courseDAO;

	@GetMapping("/courses")
	public List getCustomers() {
		return courseDAO.list();
	}

}
