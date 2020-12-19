package com.mailcast.MailCastObjects;

import java.sql.Timestamp;

public class PendingSend {
	
	public final String emailAddress;
	public final long newsletterId;
	public final String title;
	public final String content;
	private int attemptLeft;
	
	/**
	 * A pending email to be sent, only the number of attempt left can be changed
	 * @param emailAddress
	 * @param newsletterId
	 * @param title
	 * @param content
	 * @param attemptLeft
	 */
	public PendingSend(String emailAddress, long newsletterId, String title, String content, byte attemptLeft) {
		this.emailAddress = emailAddress;
		this.newsletterId = newsletterId;
		this.title = title;
		this.content = content;
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
  
        if (!(o instanceof PendingSend)) { 
            return false; 
        } 
           
        PendingSend c = (PendingSend) o; 
        
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
