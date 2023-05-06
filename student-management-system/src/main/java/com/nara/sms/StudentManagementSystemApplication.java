package com.nara.sms;

import com.nara.sms.entity.Student;
import com.nara.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		//writing logic to insert few student records
//		Student student1 = new Student("Ramesh","Mannepalli","Ramesh@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Suresh","Mannepalli","Suresh@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Tony","Stark","Tony@gmail.com");
//		studentRepository.save(student3);
	}
}
