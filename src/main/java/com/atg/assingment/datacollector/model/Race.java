package com.atg.assingment.datacollector.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {
	
	private String id;
	private String startTime;
	private List<Tracks> tracks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startDate) {
		this.startTime = startDate;
	}
	public List<Tracks> getTracks() {
		return tracks;
	}
	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}
	
	

}
