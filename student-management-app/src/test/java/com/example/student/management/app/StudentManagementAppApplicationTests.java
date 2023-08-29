package com.example.student.management.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementAppApplicationTests {
	@Autowired
	StudentService studentService;

	@BeforeEach
	public void preOperation(){
		// regNo, name, course, age
		Student s1 = new Student(1, "Salik", "BBA", 28);
		Student s2 = new Student(2, "Kalam", "BCOM", 27);
		Student s3 = new Student(3, "Ateeque", "BA", 26);
	}
	@Test
	public void addStudentTest(){
		Student expected = new Student(2, "Kalam", "BCOM", 27);
		Student output = studentService.getStudentUsingReqParam(2);

		Assertions.assertEquals(expected.getRegNo(), output.getRegNo());
		Assertions.assertEquals(expected.getName(), output.getName());
		Assertions.assertEquals(expected.getCourse(), output.getCourse());
		Assertions.assertEquals(expected.getAge(), output.getAge());
	}
	@Test
	public void getStudentTest(){
		Student expected = new Student(2, "Kalam", "BCOM", 27);
		Student output = studentService.getStudentUsingReqParam(2);

		Assertions.assertEquals(expected.getRegNo(), output.getRegNo());
		Assertions.assertEquals(expected.getName(), output.getName());
		Assertions.assertEquals(expected.getCourse(), output.getCourse());
		Assertions.assertEquals(expected.getAge(), output.getAge());
	}
	@Test
	void contextLoads() {
	}

}
