package com.reetu.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("/prototype")
public class kitchen {
	int setid;
	String setname;
	String review;
	
	public int getSetid() {
		return setid;
	}
	public void setSetid(int setid) {
		this.setid = setid;
	}
	public String getSetname() {
		return setname;
	}
	public void setSetname(String setname) {
		this.setname = setname;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	

}
