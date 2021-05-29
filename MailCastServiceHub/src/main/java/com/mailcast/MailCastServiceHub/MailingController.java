package com.mailcast.MailCastServiceHub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mailcast.WorkersHub.*;
import com.mailcast.Objects.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mailing")
public class MailingController {

	@GetMapping("/sendingLogs")
	public List<LogEntry> getSendingLogs() {
		try {
			return MockDataBase.getlogs();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@GetMapping("/newsletters")
	public List<Newsletter> getNewsletters() {
		try {
			return MockDataBase.getNewsletters();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@PostMapping("/newsletter")
	public Newsletter postNewNewsletter(@RequestBody PostingNewsletter newsletter) {
		try {
			Newsletter newNewsletter = new Newsletter(0, newsletter.title,
		    newsletter.content, new Timestamp(System.currentTimeMillis()));
			return MockDataBase.sendNewsletter(newNewsletter);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@GetMapping("/pendingMails")
	public List<PendingMail> getPendingMails() {
		try {
			return MockDataBase.getPendingMails();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
}
