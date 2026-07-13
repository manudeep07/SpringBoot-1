package com.Manudeep.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setName("Manudeep");
		student.setAge(20);
		System.out.println(student.getName());
		System.out.println(student.getAge());


	}

}
