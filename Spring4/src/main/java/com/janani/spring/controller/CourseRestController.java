package com.janani.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janani.spring.dao.CourseDAO;
import com.janani.spring.model.Course;

@CrossOrigin
@RestController
public class CourseRestController {

	@Autowired
	private CourseDAO courseDAO;

	@GetMapping("/courses")
	public List getCustomers() {
		return courseDAO.list();
	}

	@GetMapping("/courses/{code}")
	public ResponseEntity getCourse(@PathVariable("code") String code) {
		Course course = courseDAO.get(code);
		if (course == null) {
			return new ResponseEntity("No course found for code " + code, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(course, HttpStatus.OK);
	}

	@PostMapping(value = "/courses")
	public ResponseEntity createCourse(@RequestBody Course course) {
		courseDAO.create(course);
		return new ResponseEntity(course, HttpStatus.OK);
	}

	@DeleteMapping("/courses/{code}")
	public ResponseEntity deleteCourse(@PathVariable String code) {
		if (null == courseDAO.delete(code)) {
			return new ResponseEntity("No course found for code " + code, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(code, HttpStatus.OK);
	}

	@PutMapping(value="/courses/{code}")
	public ResponseEntity updateCustomer(@PathVariable String code, @RequestBody Course course) {

		course = courseDAO.update(code, course);

		if (null == course) {
			return new ResponseEntity("No Customer found for ID " + code, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(course, HttpStatus.OK);
	}

}
