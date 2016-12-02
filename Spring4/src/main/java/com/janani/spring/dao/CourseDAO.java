package com.janani.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.janani.spring.model.Course;

@Component
public class CourseDAO {
	// Dummy datatbase. Initialize with sme dummy values.
	private static List<Course> courses;
	{
		courses = new ArrayList();
		courses.add(new Course("J-101", "Core Java", "Core Java"));
		courses.add(new Course("J-102", "Servlet", "Servlet 3.0"));
	}

	/**
	 * Returns list of customers from dummy database.
	 * 
	 * @return list of customers
	 */
	public List list() {
		return courses;
	}

	/**
	 * Return course object for given code from dumy database. If customer is
	 * not found for id, returns null.
	 * 
	 * @param code
	 *            course code
	 * @return course object for given code
	 */
	public Course get(String code) {

		for (Course c : courses) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new course in dummy database. Insert new course in list.
	 * 
	 * @param course
	 *            course object
	 * @return course object
	 */
	public Course create(Course course) {
		courses.add(course);
		return course;
	}

	/**
	 * Delete the course object from dummy database. If course not found for
	 * given code, returns null.
	 * 
	 * @param code
	 * @return
	 */
	public String delete(String code) {

		for (Course c : courses) {
			if (c.getCode().equals(code)) {
				courses.remove(c);
				return code;
			}
		}
		return null;
	}

	public Course update(String code, Course course) {
		for (Course c : courses) {
			if (c.getCode().equals(code)) {
				course.setCode(c.getCode());
				courses.remove(c);
				courses.add(course);
				return course;

			}
		}
		return null;
	}
}
