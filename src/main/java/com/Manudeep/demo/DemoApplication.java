package com.Manudeep.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Student obj=new Student("Manudeep",20);
		System.out.println(obj.getAge());
		System.out.println(obj.getName());
	}

}
