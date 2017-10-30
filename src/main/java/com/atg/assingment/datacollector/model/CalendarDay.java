package com.atg.assingment.datacollector.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarDay {
	
	private String date;
	private Map<String, List<Object>> games;
	
	public CalendarDay(){}
	
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CalendarDay that = (CalendarDay) o;

		if (date != null ? !date.equals(that.date) : that.date != null) return false;
		return games != null ? games.equals(that.games) : that.games == null;
	}

	@Override
	public int hashCode() {
		int result = date != null ? date.hashCode() : 0;
		result = 31 * result + (games != null ? games.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CalendarDay{" +
				"date='" + date + '\'' +
				", games=" + games +
				'}';
	}
}
