package com.todolist.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application class
 */
@SpringBootApplication()
@EnableAutoConfiguration(/*exclude = { DataSourceAutoConfiguration.class }*/)
@ComponentScan(basePackages = "com.todolist.core.*")
public class ToDoListApplication {
	/**
	 * Run the program
	 * @param args Command line arguments
	 */

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
