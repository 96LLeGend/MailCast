package com.mailcast.MailCastObjects;

import java.sql.Timestamp;

public class Newsletter {
	
	public final long id;
	public final String title;
	public final String content;
	public final Timestamp postDateTime;
	
	/**
	 * A Newsletter has title, content and date time of posted, and once created, those can not be changed
	 * @param id
	 * @param title
	 * @param content
	 * @param postDateTime The time this newsletter is posted
	 */
	public Newsletter(long id, String title, String content, Timestamp postDateTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.postDateTime = postDateTime;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Newsletter)) { 
            return false; 
        } 
           
        Newsletter c = (Newsletter) o; 
        
        return !(
        		(this.id != c.id) ||
        		(this.title != null && !this.title.equals(c.title)) ||
        		(this.title == null && c.title != null) ||
        		(this.content != null && !this.content.equals(c.content)) ||
        		(this.content == null && c.content != null) ||
        		(this.postDateTime != null && !this.postDateTime.equals(c.postDateTime)) ||
        		(this.postDateTime == null && c.postDateTime != null)
        		);
    } 
}
