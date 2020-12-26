package com.mailcast.MailCastServiceHub;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mailcast.Objects.APIGetResult;
import com.mailcast.Objects.Subscription;
import com.mailcast.WorkersHub.MockDataBase;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@GetMapping("/mailingList")
	public APIGetResult<Subscription> getMailingList() {
		try {
			return new APIGetResult<Subscription>(MockDataBase.getSubscriptions());
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
