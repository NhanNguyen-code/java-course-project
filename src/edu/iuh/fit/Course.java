/**
 * @description: Chua class Course
 * @author: Nguyen Thanh Nhan
 * @version: 1.0
 * @created: 30-Aug-2025 7:43:07 PM
 */
package edu.iuh.fit;

public class Course {
	//Property
	private String id;
	private String title;
	private int credit;
	private String department;
	//Constructor mac dinh
	public Course() {}
	//Constructor day du
	public Course(String id, String title, int credit, String department) {
		setId(id);
		setTitle(title);
		setCredit(credit);
		setDepartment(department);
	}
	// Getters
	public int getCredit() {
		return credit;
	}

	public String getDepartment() {
		return department;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	// Setters
	public void setCredit(int credit) {
		if(credit <= 0) {
			throw new IllegalArgumentException(
					"Credit must be greater than 0");
		}
		this.credit = credit;
	}

	public void setDepartment(String department) {
		if(department == null || department.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Department must not be empty");
		}
		this.department = department;
	}

	public void setId(String id) {
		if(id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
			throw new IllegalArgumentException(
					"ID must have at least 3 characters and contain only letters or digits");
		}
		this.id = id;
	}


	public void setTitle(String title) {
		if(title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Title must not be empty");
		}
		this.title = title;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-20s %-5d %-15s", id, title, credit, department );
	}
}
