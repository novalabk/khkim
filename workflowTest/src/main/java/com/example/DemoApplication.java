package com.example;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) { 
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setBanner(new Banner() {
			
			@Override
			public void printBanner(Environment paramEnvironment, Class<?> paramClass, PrintStream out) {
				// TODO Auto-generated method stub
				out.print("\n\n\t나만의 멋진 베너랍니다! \nn".toUpperCase());
			}
		});
		SpringApplication.run(DemoApplication.class, args);
	}
}
