package com.mailcast.MailCastServiceHub;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.server.ResponseStatusException;

import com.mailcast.Objects.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/testErrorHandling")
	public String getError() {
		throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				"Fake Null Pointer Exception");
	}
}