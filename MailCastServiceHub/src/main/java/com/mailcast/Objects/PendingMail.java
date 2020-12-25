package com.mailcast.Objects;

import java.sql.Timestamp;

public class PendingMail {
	
	public final String emailAddress;
	public final long newsletterId;
	public final String title;
	public final String content;
	public final Timestamp postDateTime;
	private int attemptLeft;
	
	/**
	 * A pending email to be sent, only the number of attempt left can be changed
	 * @param emailAddress
	 * @param newsletterId
	 * @param title
	 * @param content
	 * @param postDatTime
	 * @param attemptLeft
	 */
	public PendingMail(String emailAddress, long newsletterId, String title, String content, Timestamp postDateTime, byte attemptLeft) {
		this.emailAddress = emailAddress;
		this.newsletterId = newsletterId;
		this.title = title;
		this.content = content;
		this.postDateTime = postDateTime;
		this.attemptLeft = attemptLeft;
	}
	
	public int getAttemptLeft() {
		return this.attemptLeft;
	}
	
	public void setAttemptLeft(int attemptLeft) {
		this.attemptLeft = attemptLeft;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof PendingMail)) { 
            return false; 
        } 
           
        PendingMail c = (PendingMail) o; 
        
        return !(
        		(this.emailAddress != null && !this.emailAddress.equals(c.emailAddress)) ||
        		(this.emailAddress == null && c.emailAddress != null) ||
        		(this.newsletterId != c.newsletterId) ||
        		(this.title != null && !this.title.equals(c.title)) ||
        		(this.title == null && c.title != null) ||
        		(this.content != null && !this.content.equals(c.content)) ||
        		(this.content == null && c.content != null) ||
        		(this.attemptLeft != c.attemptLeft)
        		);
    } 
}
