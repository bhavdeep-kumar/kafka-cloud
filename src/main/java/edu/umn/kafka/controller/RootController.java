package edu.umn.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Root Controller
 */
@RestController
public class RootController
{
	@GetMapping("/")
	public String healthCheck()  {
		return "Health Check - V1.0";
	} 
}  
