package com.mailcast.MailCastServiceHub;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mailcast.MailCastObjects.*;

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
	
	@GetMapping("/getResult")
	public APIGetResult<Subscription> getResult() {
		Subscription subs1 = new Subscription("abc@efg.com", new Timestamp(2020, 12, 19, 8, 10, 20, 30));
		Subscription subs2 = new Subscription("123@efg.com", new Timestamp(2020, 12, 19, 8, 10, 20, 30));
		List<Subscription> results = new ArrayList<Subscription>();
		results.add(subs1);
		results.add(subs2);
		return new APIGetResult<Subscription>(true, "", results);
	}
}