package com.atg.assingment.datacollector.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BetType {

	String betType;
	List<Race> upcoming;
	public String getBetType() {
		return betType;
	}
	public void setBetType(String betType) {
		this.betType = betType;
	}
	public List<Race> getUpcoming() {
		return upcoming;
	}
	public void setUpcoming(List<Race> upcoming) {
		this.upcoming = upcoming;
	}
}
