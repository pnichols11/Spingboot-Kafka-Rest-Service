/**
 * 
 */
package com.clc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * <b>Description:</b>
 * </p>
 * <p>
 * This is the SpringBoot starter class for the application. This class
 * will start Tomcat and run as a standard Spring MVC application
 * </p>
 * <p>
 * @author Dr. Paul W. Nichols -- Computer Logic
 * </p>
 * <p>
 * @version 1.0
 * </p>
 * <p>
 * All rights reserved
 * </p>
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication app= new SpringApplication(Application.class);
		app.run(args);

	}
	
	public void run(String... strings) {
    	System.out.println(" SpringBoot Rest-Kafka Example Started");
    	
    }  

}
