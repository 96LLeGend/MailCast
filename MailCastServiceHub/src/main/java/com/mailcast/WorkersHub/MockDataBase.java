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

	private static List<Subscription> subscriptions = new ArrayList<Subscription>();
	private static List<Newsletter> newsletters = new ArrayList<Newsletter>();
	private static List<LogEntry> logs = new ArrayList<LogEntry>();
	private static List<PendingMail> pendingMails = new ArrayList<PendingMail>();
	
	public static void Initialize() {
		Subscription subs1 = new Subscription("abc@efg.com", new Timestamp(2020, 12, 19, 8, 10, 20, 30));
		Subscription subs2 = new Subscription("123@efg.com", new Timestamp(2020, 12, 19, 8, 10, 20, 30));
		subscriptions.add(subs1);
		subscriptions.add(subs2);
		
		Newsletter news1 = new Newsletter(newsletterCounter.incrementAndGet(), "title 1", "content 1", new Timestamp(2020, 12, 22, 8, 10, 20, 30));
		Newsletter news2 = new Newsletter(newsletterCounter.incrementAndGet(), "title 2", "content 2", new Timestamp(2020, 12, 25, 8, 11, 20, 30));
		newsletters.add(news1);
		newsletters.add(news2);
		
		LogEntry log1 = new LogEntry(logEntryCounter.incrementAndGet(), "abc@efg.com", news1, false, new Timestamp(2020, 12, 22, 8, 10, 20, 31));
		LogEntry log2 = new LogEntry(logEntryCounter.incrementAndGet(), "123@efg.com", news1, true, new Timestamp(2020, 12, 22, 8, 10, 20, 32));
		logs.add(log1);
		logs.add(log2);
		
		PendingMail pending1 = new PendingMail("abc@efg.com", 2, news2.title, news2.content, news2.postDateTime, (byte)2);
		PendingMail pending2 = new PendingMail("123@efg.com", 2, news2.title, news2.content, news2.postDateTime, (byte)2);
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
	
	public static Subscription subscribe(String emailAddress) {
		Subscription subscription = new Subscription(emailAddress, new Timestamp(new Date().getTime()));
		subscriptions.add(subscription);
		return subscriptions.stream().max(Comparator.comparing(Subscription::getSubscriptionTimestamp)).orElse(null);
	}
	
	public static void unsubscribe (String emailAddress) {
		subscriptions.remove(new Subscription(emailAddress, new Timestamp(new Date().getTime())));
	}
	
	public static Newsletter sendNewsletter(Newsletter newsletter) {
		Newsletter newNewsletter = new Newsletter(newsletterCounter.incrementAndGet(), newsletter.title, newsletter.content, newsletter.postDateTime);
		newsletters.add(newNewsletter);
		return newsletters.stream().max(Comparator.comparing(Newsletter::getId)).orElse(null);
	}
}