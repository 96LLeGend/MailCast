package com.mailcast.Objects;

import java.sql.Timestamp;

public class NewsletterAPIO {
	
	public final String title;
	public final String content;
	public final Timestamp postDateTime;
	
	public NewsletterAPIO(String title, String content, Timestamp postDateTime) {
		this.title = title;
		this.content = content;
		this.postDateTime = postDateTime;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof NewsletterAPIO)) { 
            return false; 
        } 
           
        NewsletterAPIO c = (NewsletterAPIO) o; 
        
        return !(
        		(this.title != null && !this.title.equals(c.title)) ||
        		(this.title == null && c.title != null) ||
        		(this.content != null && !this.content.equals(c.content)) ||
        		(this.content == null && c.content != null) ||
        		(this.postDateTime != null && !this.postDateTime.equals(c.postDateTime)) ||
        		(this.postDateTime == null && c.postDateTime != null)
        		);
    } 
}
