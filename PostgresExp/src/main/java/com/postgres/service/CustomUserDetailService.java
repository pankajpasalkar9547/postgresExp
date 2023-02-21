package com.postgres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.postgres.Entity.CustomUserDetail;
import com.postgres.Entity.StudentInfo;
import com.postgres.repository.StudentRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentInfo student = studentRepo.findByUsername(username);
		
		if(student == null)
		{
			throw new UsernameNotFoundException("Username Not found"); 
		}
		System.out.println("Stduent :" + student.getUsername());
		System.out.println("Stduent :" + student.getPassword());

		return new CustomUserDetail(student);
	}

}
