package com.goi.edu.stud.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.goi.edu.stud.vo.Courses;
import com.goi.edu.stud.vo.EduStudent;

@Component
public class EduStudentUtil {

	private static Map<String, EduStudent> studentsMap = new HashMap<String, EduStudent>();

	public EduStudentUtil() {
		EduStudent eduStud1 = new EduStudent.EduStudentBuilder("10", "Ajay").lastname("Verma")
				.courses(getCourses(5)).courses(getCourses(1)).build();
			
		EduStudent eduStud2 = new EduStudent.EduStudentBuilder("20", "Vijay").lastname("Verma")
					.courses(getCourses(2)).courses(getCourses(4)).build();
					
		EduStudent eduStud3 = new EduStudent.EduStudentBuilder("30", "Manoj").lastname("Verma").courses(getCourses(3)).build();
		EduStudent eduStud4 = new EduStudent.EduStudentBuilder("40", "Prem").lastname("Verma").courses(getCourses(6)).build();
		EduStudent eduStud5 = new EduStudent.EduStudentBuilder("50", "Suman").lastname("Verma").courses(getCourses(4)).build();

		studentsMap.put("10", eduStud1);
		studentsMap.put("20", eduStud2);
		studentsMap.put("30", eduStud3);
		studentsMap.put("40", eduStud4);
		studentsMap.put("50", eduStud5);
	}

	public Collection<EduStudent> getStudents() {
		return studentsMap.values();
	}

	public EduStudent getStudent(String studId) {
		EduStudent stud = studentsMap.get(studId);
		if (stud == null)
			stud = new EduStudent("00", "undefined", "undefined");

		return stud;
	}

	public Courses getCourses(int sno) {
		Courses courses;

		switch (sno) {
		case 1:
			courses = new Courses.CourseBuilder("PUC").board("TSEB")
					.subjects("Telugu,English,Physics, Chemistry,Maths")
					.build();
			break;
		case 2:
			courses = new Courses.CourseBuilder("BSc").board("JNTU")
					.subjects("Telugu,English, Databases, Applications, MIS")
					.build();
			break;
		case 3:
			courses = new Courses.CourseBuilder("MSc").board("JNTU")
					.subjects("Languages, Databases, Cloud Computing").build();
			break;
		case 4:
			courses = new Courses.CourseBuilder("MCA")
					.board("Bangalore University")
					.subjects("Languages, Databases, Cloud").build();
			break;
		case 5:
			courses = new Courses.CourseBuilder("BCom")
					.board("Bangalore University").subjects("Legdering, Laws")
					.build();
			break;
		case 6:
			courses = new Courses.CourseBuilder("MCom")
					.board("Osmania University")
					.subjects("Legder, Business Model, Company laws").build();
			break;
		case 7:
			courses = new Courses.CourseBuilder("MPhil")
					.board("Osmania University")
					.subjects("Philosophy, Social Science").build();
			break;
		case 8:
			courses = new Courses.CourseBuilder("BTech").board("JNTU")
					.subjects("Data Structure,DB,Java, SE").build();
			break;
		case 9:
			courses = new Courses.CourseBuilder("MTech").board("JNTU")
					.subjects("SE, Hardware, Languages, AI").build();

			break;

		default:
			courses = new Courses.CourseBuilder("SSC").board("TSEB")
					.subjects("Telugu,English,Hindi,Maths,Science,Social")
					.build();
			break;
		}

		return courses;
	}

}
