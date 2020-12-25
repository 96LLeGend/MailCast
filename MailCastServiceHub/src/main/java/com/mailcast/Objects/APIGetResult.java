package com.mailcast.Objects;

import java.util.List;

public class APIGetResult<T> {

	public final boolean success;
	public final String errorMessage;
	public final List<T> result; 
	public final int totalCount;
	
	public APIGetResult(boolean success, String errorMessage, List<T> result) {
		this.success = success;
		this.errorMessage = errorMessage;
		this.result = result;
		if(result == null || result.isEmpty())
			this.totalCount = 0;
		else
			this.totalCount = result.size();
	}
}
