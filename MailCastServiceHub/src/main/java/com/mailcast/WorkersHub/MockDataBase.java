package com.mailcast.WorkersHub;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.mailcast.Objects.*;

public class MockDataBase {
	
	private final static AtomicLong newsletterCounter = new AtomicLong();
	private final static AtomicLong logEntryCounter = new AtomicLong();
	private final static AtomicLong pendingLettersCounter = new AtomicLong();

	private static List<Subscription> subscriptions = new ArrayList<Subscription>();
	private static List<Newsletter> newsletters = new ArrayList<Newsletter>();
	private static List<LogEntry> logs = new ArrayList<LogEntry>();
	private static List<PendingMail> pendingMails = new ArrayList<PendingMail>();
	
	public static void Initialize() {
		Subscription subs1 = new Subscription("abc@efg.com", new Timestamp(System.currentTimeMillis()));
		Subscription subs2 = new Subscription("123@efg.com", new Timestamp(System.currentTimeMillis()));
		subscriptions.add(subs1);
		subscriptions.add(subs2);
		
		Newsletter news1 = new Newsletter(newsletterCounter.incrementAndGet(), "title 1", "content 1", new Timestamp(System.currentTimeMillis()));
		Newsletter news2 = new Newsletter(newsletterCounter.incrementAndGet(), "title 2", "content 2", new Timestamp(System.currentTimeMillis()));
		newsletters.add(news1);
		newsletters.add(news2);
		
		LogEntry log1 = new LogEntry(logEntryCounter.incrementAndGet(), "abc@efg.com", news1, false, new Timestamp(2020, 12, 22, 8, 10, 20, 31));
		LogEntry log2 = new LogEntry(logEntryCounter.incrementAndGet(), "123@efg.com", news2, true, new Timestamp(2020, 12, 22, 8, 10, 20, 32));
		logs.add(log1);
		logs.add(log2);
		
		PendingMail pending1 = new PendingMail(pendingLettersCounter.incrementAndGet(), "abc@efg.com", 2, news2.title, news2.content, news2.postDateTime, (byte)2);
		PendingMail pending2 = new PendingMail(pendingLettersCounter.incrementAndGet(), "123@efg.com", 2, news2.title, news2.content, news2.postDateTime, (byte)2);
		pendingMails.add(pending1);
		pendingMails.add(pending2);
	}
	
	public static List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	
	public static List<Newsletter> getNewsletters() {
		return newsletters;
	}
	
	public static List<LogEntry> getlogs() {
		return logs;
	}
	
	public static List<PendingMail> getPendingMails() {
		return pendingMails;
	}
	
	public static boolean subscriptionExist(String emailAddress) {
		return subscriptions.stream().anyMatch(e -> e.emailAddress.equals(emailAddress));
	}
	
	public static Subscription subscribe(String emailAddress) throws Exception {
		if(subscriptionExist(emailAddress)) {
			throw new Exception("Email address already exist");
		}
		
		Subscription subscription = new Subscription(emailAddress, new Timestamp(new Date().getTime()));
		subscriptions.add(subscription);
		return subscriptions.stream().max(Comparator.comparing(Subscription::getSubscriptionTimestamp)).orElse(null);
	}
	
	public static void unsubscribe (String emailAddress) {
		subscriptions.removeIf(e -> e.emailAddress.equals(emailAddress));
	}
	
	public static Newsletter sendNewsletter(Newsletter newsletter) {
		Newsletter newNewsletter = new Newsletter(newsletterCounter.incrementAndGet(), newsletter.title, newsletter.content, newsletter.postDateTime);
		newsletters.add(newNewsletter);
		newNewsletter = newsletters.stream().max(Comparator.comparing(Newsletter::getId)).orElse(null);
		if(newNewsletter != null) {
			for(Subscription sus : subscriptions) {
				PendingMail newPending = new PendingMail(pendingLettersCounter.incrementAndGet(), sus.emailAddress, newNewsletter.id, newNewsletter.title, newNewsletter.content, newNewsletter.postDateTime, (byte)2);
				pendingMails.add(newPending);
			}
		}
		return newNewsletter;
		
	}
}
