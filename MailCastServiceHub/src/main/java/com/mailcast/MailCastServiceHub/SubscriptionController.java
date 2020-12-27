package com.mailcast.MailCastServiceHub;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mailcast.Objects.APIGetResult;
import com.mailcast.Objects.Newsletter;
import com.mailcast.Objects.NewsletterAPIO;
import com.mailcast.Objects.Subscription;
import com.mailcast.WorkersHub.MockDataBase;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@GetMapping("/mailingList")
	public List<Subscription> getMailingList() {
		try {
			return MockDataBase.getSubscriptions();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@PostMapping("/subscribe")
	public Subscription subscribe(@RequestBody String emailAddress) {
		try {
			return MockDataBase.subscribe(emailAddress);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@DeleteMapping("/unsubscribe/{emailAddress}")
	public void unsubscribe(@PathVariable String emailAddress) {
		try {
			MockDataBase.unsubscribe(emailAddress);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
    }
}
