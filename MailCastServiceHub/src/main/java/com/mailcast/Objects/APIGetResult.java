package com.mailcast.Objects;

import java.util.List;

public class APIGetResult<T> {

	public final List<T> result; 
	public final int totalCount;
	
	public APIGetResult(List<T> result) {
		this.result = result;
		if(result == null || result.isEmpty())
			this.totalCount = 0;
		else
			this.totalCount = result.size();
	}
}
