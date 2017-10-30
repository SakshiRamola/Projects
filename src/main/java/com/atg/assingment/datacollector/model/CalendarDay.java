package com.atg.assingment.datacollector.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarDay {
	
	private String date;
	private Map<String, List<Object>> games;
	

	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, List<Object>> getGames() {
		return games;
	}
	public void setGames(Map<String, List<Object>> games) {
		this.games = games;
	}



}
