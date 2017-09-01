package com.example.springbootdemo;

import com.example.springbootdemo.Repository.UserRepositiry;
import com.example.springbootdemo.domain.User;
import com.example.springbootdemo.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.example.springbootdemo")
@RestController
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Autowired
	private WelcomeService service;
	@Autowired
	private UserRepositiry userRepositiry;

	@RequestMapping("/hello")
	public String sayHello() {
		User user = new User("Mike", "asdfasdfasdf", "albert@mail.com");
		userRepositiry.save(user);
		System.out.println("=====================");
		System.out.println(userRepositiry.findByName("Mike").getEmail());

		return service.retrieveWelcomeMessage();
	}
}

