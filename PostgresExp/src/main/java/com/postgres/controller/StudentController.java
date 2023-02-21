package com.postgres.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.DTO.StudentInfoDTO;
import com.postgres.Entity.StudentInfo;
import com.postgres.exception.NoStudentFoundException;
import com.postgres.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	
	@GetMapping("/all")
	private ResponseEntity<Object> getAllStudent()
	{
		List<StudentInfoDTO> student = studentService.getStudents();
		System.out.println("Student " +student);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(student,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/save")
	private ResponseEntity<Object> saveStudent(@RequestBody StudentInfoDTO studentInfo)
	{
		StudentInfo response = studentService.saveStudentInfo(studentInfo);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getStudent/{studID}")
	private ResponseEntity<Object> getStudent(@PathVariable("studID") int id)
	{
		StudentInfo student = studentService.getStudentByID(id);
		if(student.getName().isEmpty()||student.getName()=="")
		{
			throw new NoStudentFoundException("Student not found");
		}
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(student,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getStudent/limit/{noOfRec}")
	private ResponseEntity<Object> getLimitedStudent(@PathVariable long noOfRec)
	{
		List<StudentInfo> stud = studentService.getLimitedStud(noOfRec);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(stud,HttpStatus.OK);
		return responseEntity;
	}

}
