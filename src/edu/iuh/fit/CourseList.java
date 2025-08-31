/**
 * @description: Chua class CourseList dung de thuc hien cac chuc nang
 * @author: Nguyen Thanh Nhan
 * @version: 1.0
 * @created: 30-Aug-2025 7:44:57 PM
 */
package edu.iuh.fit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CourseList {
	//Property
	private int count;
	private Course[] courses;
	
	public CourseList(int size) {
		if(size <= 0) {
			throw new 
			IllegalArgumentException(
						"Length of the array must be greater than 0");
		}
		this.courses = new Course[size];
		this.count = 0;
	}
	
	public boolean addCourse(Course c) {
		if(exist(c)) {
			System.out.println("Course ID already exist");
			return false;
		}
		if(count >= courses.length) {
			System.out.println("Course list is full");
			return false;
		}
		courses[count++] = c;
		return true;
	}
	
	public boolean exist(Course c) {
		for(int i = 0; i < count; i++) {
			if(courses[i].getId().equalsIgnoreCase(c.getId())) 
			return true;
		}
		return false;
	}
	//Getters
	public Course[] getCourses() {
		return Arrays.copyOf(courses, count);
	}
	
	public String findDepartmentWithMostCourses() {
		if(count == 0) return null;
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < count; i++) {
			map.put(courses[i].getDepartment(), map.getOrDefault(courses[i].getDepartment(), 0) + 1);
		}
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	public Course[] findMaxCreditCourses() {
		if(count == 0) return null;
		int maxCredit = courses[0].getCredit();
		for(int i = 1; i < count; i++) {
			if (courses[i].getCredit() > maxCredit) {
				maxCredit = courses[i].getCredit();
			}
		}
		int cnt = 0;
		Course[] tmp = new Course[count];
		for(int i = 0; i < count; i++) {
			if(courses[i].getCredit() == maxCredit) {
				tmp[cnt++] = courses[i];
			}
		}
		if (cnt == 0) return new Course[0];
		return Arrays.copyOf(tmp, cnt);
	}
	
	public boolean removeCourse(String id) {
		for(int i = 0; i < count; i++) {
			if(courses[i].getId().equalsIgnoreCase(id)) {
				for(int j = i; j < count - 1; j++) {
					courses[j] = courses[j + 1];
				}
				courses[--count] = null;
				return true;
			}
		}
		return false;
	}
	
	public Course[] searchCourse(String key) {
		int cnt = 0;
		Course[] temp = new Course[count];
		for(int i = 0; i < count; i++) {
			if(courses[i].getTitle().toLowerCase().contains(key.toLowerCase())) {
				temp[cnt++] = courses[i];
			}
		}
		if (cnt == 0) return new Course[0];
		return Arrays.copyOf(temp, cnt);
	}
	
	public Course[] searchCourseByDepartment(String dept) {
		int cnt = 0;
		Course[] tmp = new Course[count];
		for(int i = 0; i < count; i++) {
			if(courses[i].getDepartment().equalsIgnoreCase(dept)) {
				tmp[cnt++] = courses[i];
			}
		}
		if (cnt == 0) return new Course[0];
		return Arrays.copyOf(tmp, cnt);
	}
	
	public Course searchCourseById(String id) {
		for(int i = 0; i < count; i++) {
			if(courses[i].getId().equalsIgnoreCase(id)) {
				return courses[i];
			}
		}
		return null;
	}
	
	public Course[] sortCourses() {
		Course[] sorted = Arrays.copyOf(courses, count);
		Arrays.sort(sorted, Comparator.comparing(Course::getTitle, String.CASE_INSENSITIVE_ORDER));
		return sorted;
	}
	
}
