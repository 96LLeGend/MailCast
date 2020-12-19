package com.mailcast.MailCastObjects;

import java.sql.Timestamp;

public class SentHistory {
	
	public final long id;
	public final String emailAddress;
	public final long newsletterId;
	public final Newsletter newsletter;
	public final boolean success;
	public final Timestamp sentDateTime;
	
	/**
	 * A sent history, and once created, those can not be changed
	 * @param id
	 * @param emailAddress
	 * @param newsletterId
	 * @param newsletter
	 * @param success
	 * @param sentDateTime
	 */
	public SentHistory(long id, String emailAddress, Newsletter newsletter, boolean success, Timestamp sentDateTime) {
		this.id = id;
		this.emailAddress = emailAddress;
		this.newsletterId = newsletter == null ? 0 : newsletter.id;
		this.newsletter = newsletter;
		this.success = success;
		this.sentDateTime = sentDateTime;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof SentHistory)) { 
            return false; 
        } 
           
        SentHistory c = (SentHistory) o; 
        
        return !(
        		(this.id != c.id) ||
        		(this.emailAddress != null && !this.emailAddress.equals(c.emailAddress)) ||
        		(this.emailAddress == null && c.emailAddress != null) ||
        		(this.newsletter != null && !this.newsletter.equals(c.newsletter)) ||
        		(this.newsletter == null && c.newsletter != null) ||
        		(this.success != c.success) ||
        		(this.sentDateTime != null && !this.sentDateTime.equals(c.sentDateTime)) ||
        		(this.sentDateTime == null && c.sentDateTime != null)
        		);
    } 
}
