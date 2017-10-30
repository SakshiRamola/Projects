package com.atg.assingment.datacollector.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {
	
	private String id;
	private String startTime;
	private List<Track> tracks;
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
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Race race = (Race) o;

		if (id != null ? !id.equals(race.id) : race.id != null) return false;
		if (startTime != null ? !startTime.equals(race.startTime) : race.startTime != null) return false;
		return tracks != null ? tracks.equals(race.tracks) : race.tracks == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
		result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Race{" +
				"id='" + id + '\'' +
				", startTime='" + startTime + '\'' +
				", tracks=" + tracks +
				'}';
	}
}
