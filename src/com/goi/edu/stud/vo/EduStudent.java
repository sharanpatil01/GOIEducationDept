package com.goi.edu.stud.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EduStudent implements Serializable{

	private static final long serialVersionUID = -3107337924487723768L;

	private String stId = "100";
	private String firstName = "Sharan";
	private String lastName = "Patil";
	private List<Courses> coursesCompleted;

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Courses> getCoursesCompleted() {
		return coursesCompleted;
	}

	public void setCoursesCompleted(List<Courses> coursesCompleted) {
		this.coursesCompleted = coursesCompleted;
	}

	public EduStudent() {
	}

	public EduStudent(String iid, String fn, String ln) {
		this.stId = iid;
		this.firstName = fn;
		this.lastName = ln;
	}

	public EduStudent(String iid, String fn) {
		this.stId = iid;
		this.firstName = fn;
	}
	
	public EduStudent(EduStudentBuilder eduStudentBuilder) {
		this.stId = eduStudentBuilder.stId;
		this.firstName = eduStudentBuilder.firstName;
		this.lastName = eduStudentBuilder.lastName;
		this.coursesCompleted = eduStudentBuilder.coursesCompleted;
	}


	public static class EduStudentBuilder {
		private final String stId;
		private final String firstName;
		private String lastName = "Patil";
		private List<Courses> coursesCompleted;

		public EduStudentBuilder(String studid, String fname){
			this.stId = studid;
			this.firstName = fname;
		}
		
		public EduStudentBuilder lastname(String ln){
			this.lastName = ln;
			return this;
		}
		
		public EduStudentBuilder courses(Courses course){
			if (this.coursesCompleted == null){
				this.coursesCompleted = new ArrayList<Courses>();
			}
			this.coursesCompleted.add(course);
			return this;
		}
		
		public EduStudentBuilder listSubjects(){
			List<Courses> crslist = new ArrayList<Courses>();
			List<String> sublist = new ArrayList<String>();
			
			for (Courses course : crslist) {

				String[] subjects = course.getSubjects().split(",");
				for (String subject : subjects) {
					System.out.println(subject);
					sublist.add(subject);
				}
			}
			 			
			return this;
			
		}
	
		public EduStudent build(){
			return new EduStudent(this);
		}
	}
}
