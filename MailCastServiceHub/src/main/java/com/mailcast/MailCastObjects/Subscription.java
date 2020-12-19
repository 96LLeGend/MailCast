package com.mailcast.MailCastObjects;

import java.sql.Timestamp;

public class Subscription {
	
	public final String emailAddress;
	public final Timestamp subscriptionTimestamp;
	
	/**
	 * A Subscription has an emailAddress and a subscriptionTimestamp, and once created, those can not be changed
	 * @param emailAddress The email address, must be unique
	 * @param subscriptionTimestamp The time of subscription, in UTC time
	 */
	public Subscription(String emailAddress, Timestamp subscriptionTimestamp) {
		this.emailAddress = emailAddress.trim();
		this.subscriptionTimestamp = subscriptionTimestamp;
	}
	
    @Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Subscription)) { 
            return false; 
        } 
           
        Subscription c = (Subscription) o; 
          
        //subscriptionTimestamp is only for querying, don't care if they are the same
        return this.emailAddress.equals(c.emailAddress.trim()); 
    } 
}