package com.postgres.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private int techerId;

	@Column(name = "TeacherName")
	private String TeacherName;
	
	//@Column(name = "StudTeach")
	
	@ManyToOne
	private StudentInfo studentId;

	public Teacher() {

	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	

}
