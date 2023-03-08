package com.JerseyExp.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jersey.DTO.StudentInfoDTO;
import com.jersey.Service.JerseyService;

@RestController
@RequestMapping("/student")
public class JerseyController {
	
	@Autowired
	JerseyService jerseyService;
	
	@GetMapping("/getData")
	private ResponseEntity<List<StudentInfoDTO>> getStudent()
	{
		List<StudentInfoDTO> dto = jerseyService.getData();
		System.out.println("After get Data method");
		return null;
	}

}
