package com.postgres.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.postgres.DTO.StudentInfoDTO;
import com.postgres.Entity.StudentInfo;
import com.postgres.exception.NoStudentFoundException;
import com.postgres.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Cacheable(cacheNames ="students")
	public List<StudentInfoDTO> getStudents() {
		
		List<StudentInfo> students = (List<StudentInfo>) studentRepo.findAll();
		if (students.isEmpty() || students == null) {
			throw new NoStudentFoundException("No Entries for student");
		}
		List<StudentInfoDTO> studentInfoDTOs = new ArrayList<>();
		for (StudentInfo student : students) {
			StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
			studentInfoDTO.setName(student.getName());
			studentInfoDTO.setUsername(student.getUsername());
			studentInfoDTO.setPassword(student.getPassword());
			studentInfoDTO.setId(student.getId());
			studentInfoDTOs.add(studentInfoDTO);
		}
		return studentInfoDTOs;
	}

	public StudentInfo saveStudentInfo(StudentInfoDTO studentInfo) throws NullPointerException {

		StudentInfo studentInfo2 = new StudentInfo();
		System.out.println(studentInfo.getName());
		try {
			if (!studentInfo.getName().isEmpty() || studentInfo.getName() != null || studentInfo.getName() != "") {
				studentInfo2.setId(studentInfo.getId());
				studentInfo2.setName(studentInfo.getName());
				studentInfo2.setUsername(studentInfo.getUsername());
				studentInfo2.setPassword(bCryptPasswordEncoder.encode(studentInfo.getPassword()));
				StudentInfo s = studentRepo.save(studentInfo2);
				return s;
			}
		} catch (NullPointerException ex) {
			throw new NullPointerException("Student name can't be null");
		}
		return null;
	}

	public StudentInfo getStudentByID(int id) {
		StudentInfo student = studentRepo.findById(id);
		try {
			if (!student.getName().isEmpty() || student.getName() != "") {
				return student;
			} else {
				throw new NoStudentFoundException();
			}
		} catch (NoStudentFoundException ex) {
			throw new NoStudentFoundException();
		}

		// return null;
	}

	public List<StudentInfo> getLimitedStud(long noOfRec) {
		List<StudentInfo> stud = (List<StudentInfo>) studentRepo.findAll();
		List<StudentInfo> limStud = stud.stream()
										//.filter)
										.sorted(Comparator.comparingInt(StudentInfo::getId).reversed())
										.limit(noOfRec)
										.collect(Collectors.toList());
		
		
		return limStud;
	}
	@Scheduled(cron = "* * * ? * *")
	public void getMsgPerSec()
	{
		System.out.println("Scheduler Activated");
	}

}
