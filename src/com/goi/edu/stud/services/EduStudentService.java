package com.goi.edu.stud.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goi.edu.stud.util.EduStudentUtil;
import com.goi.edu.stud.vo.EduStudent;

@RestController
@RequestMapping(value = "/goi/edu/student")
public class EduStudentService {

	@Autowired
	EduStudentUtil stUtil;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<EduStudent> getStudents() {
		// i) /HydUniv/student/
		return stUtil.getStudents();
	}

	@RequestMapping(value = "/find/{studId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EduStudent getStudent(@PathVariable(value = "studId") String studId) {
		// ii) /HydUniv/student/find/{regId}
		return stUtil.getStudent(studId);
	}

	// iv) /HydUniv/student/getdetails/{regId}/{fn}/{ln}
	public String getStudentsPastDetails(
			@PathVariable(value = "regId") String regId,
			@PathVariable(value = "fn") String firstname,
			@PathVariable(value = "ln") String lastname) {

		return "fault:";

	}

}
