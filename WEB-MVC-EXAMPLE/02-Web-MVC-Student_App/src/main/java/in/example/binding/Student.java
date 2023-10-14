package in.example.binding;

import java.util.Arrays;

public class Student {

	private String name;
	private String email;
	private String gender;
	private String courses;
	private String[] timings;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String[] getTimings() {
		return timings;
	}
	public void setTimings(String[] timings) {
		this.timings = timings;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", gender=" + gender + ", courses=" + courses
				+ ", timings=" + Arrays.toString(timings) + "]";
	}
	
	
	
	}
