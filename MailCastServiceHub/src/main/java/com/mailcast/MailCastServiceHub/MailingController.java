package com.mailcast.MailCastServiceHub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mailcast.WorkersHub.*;
import com.mailcast.Objects.*;

@RestController
@RequestMapping("/mailing")
public class MailingController {

	@GetMapping("/sendingLogs")
	public APIGetResult<LogEntry> getSendingLogs() {
		try {
			return new APIGetResult<LogEntry>(MockDataBase.getlogs());
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@GetMapping("/newsletters")
	public APIGetResult<Newsletter> getNewsletters() {
		try {
			return new APIGetResult<Newsletter>(MockDataBase.getNewsletters());
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@GetMapping("/pendingMails")
	public APIGetResult<PendingMail> getPendingMails() {
		try {
			return new APIGetResult<PendingMail>(MockDataBase.getPendingMails());
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
}
