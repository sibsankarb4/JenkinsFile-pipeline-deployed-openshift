package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class JenkinsFileOpenshiftExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsFileOpenshiftExampleApplication.class, args);
	}
	
	@GetMapping("/info")
	public String welcome() {
		return "++++++++++++++++++++++++++++ Welcome to IBM Redhat Openshift .++++++++++++++++++++++++++++ ";
	}

	@GetMapping("/{input}")
	public String congrats(@PathVariable String input) {
		return "Hello " + input + ", Your application deployed successfully. Cheers...!!!";
	}


}
