package com.mailcast.MailCastServiceHub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailcast.WorkersHub.*;
import com.mailcast.Objects.*;

@RestController
public class Controller {

	@GetMapping("/mailingList")
	public APIGetResult<Subscription> getMailingList() {
		return new APIGetResult<Subscription>(true, "", MockDataBase.getSubscriptions());
	}
	
	@GetMapping("/sendingLogs")
	public APIGetResult<LogEntry> getSendingLogs() {
		return new APIGetResult<LogEntry>(true, "", MockDataBase.getlogs());
	}
	
	@GetMapping("/newsletters")
	public APIGetResult<Newsletter> getNewsletters() {
		return new APIGetResult<Newsletter>(true, "", MockDataBase.getNewsletters());
	}
	
	@GetMapping("/pendingMails")
	public APIGetResult<PendingMail> getPendingMails() {
		return new APIGetResult<PendingMail>(true, "", MockDataBase.getPendingMails());
	}
	
	@DeleteMapping("/unsubscribe/{emailAddress}")
	public void unsubscribe(@PathVariable String emailAddress) {
		MockDataBase.unsubscribe(emailAddress);
    }
}
