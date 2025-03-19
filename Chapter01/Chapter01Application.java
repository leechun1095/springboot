package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.rubypaper","com.ruby"})
public class Chapter01Application {

	public static void main(String[] args) {
		// SpringBoot 내장 Tomcat 구동 시
		// SpringApplication.run(Chapter01Application.class, args);
				
		// Java Application 으로 실행하고자 할 때 
	    SpringApplication application = new
	    SpringApplication(Chapter01Application.class);
	    application.setWebApplicationType(WebApplicationType.NONE);
	    // application.setWebApplicationType(WebApplicationType.SERVLET);
	    // spirng Banner off 기능
	    application.setBannerMode(Banner.Mode.OFF);
	    application.run(args); 
	}
}
