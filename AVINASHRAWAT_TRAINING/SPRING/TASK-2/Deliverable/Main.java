package com.shristi.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.training");
		
		Student student=(Student)context.getBean("student");
		
		System.out.println(student);
		
		Department department=context.getBean("department",Department.class);
		System.out.println(department);

	}

}
