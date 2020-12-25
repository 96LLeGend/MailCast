package com.mailcast.Objects;

import java.sql.Timestamp;

public class Subscription {
	
	public final String emailAddress;
	public final Timestamp subscriptionTimestamp;
	
	/**
	 * A Subscription has an emailAddress and a subscriptionTimestamp, and once created, those can not be changed
	 * @param emailAddress The email address, must be unique and can not be null or empty
	 * @param subscriptionTimestamp The time of subscription, in UTC time
	 */
	public Subscription(String emailAddress, Timestamp subscriptionTimestamp) {
		this.emailAddress = emailAddress == null ? "" : emailAddress.trim();
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
        if(c.emailAddress == null || c.emailAddress.trim().isEmpty())
        	return false;
          
        //subscriptionTimestamp is only for querying, don't care if they are the same
        return this.emailAddress.equals(c.emailAddress.trim()); 
    } 
}
