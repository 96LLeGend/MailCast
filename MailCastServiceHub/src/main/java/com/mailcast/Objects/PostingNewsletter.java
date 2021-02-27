package com.mailcast.Objects;

import java.sql.Timestamp;

public class PostingNewsletter {
	
	public final String title;
	public final String content;
	
	public PostingNewsletter(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof PostingNewsletter)) { 
            return false; 
        } 
           
        PostingNewsletter c = (PostingNewsletter) o; 
        
        return !(
        		(this.title != null && !this.title.equals(c.title)) ||
        		(this.title == null && c.title != null) ||
        		(this.content != null && !this.content.equals(c.content)) ||
        		(this.content == null && c.content != null)
        		);
    } 
}
