package com.atg.assingment.datacollector.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BetType {

	private String betType;
	private List<Race> upcoming;

	public BetType() {
	}

	public BetType(String betType, List<Race> upcoming) {
		this.betType = betType;
		this.upcoming = upcoming;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BetType betType1 = (BetType) o;

		if (betType != null ? !betType.equals(betType1.betType) : betType1.betType != null) return false;
		return upcoming != null ? upcoming.equals(betType1.upcoming) : betType1.upcoming == null;
	}

	@Override
	public int hashCode() {
		int result = betType != null ? betType.hashCode() : 0;
		result = 31 * result + (upcoming != null ? upcoming.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BetType{" +
				"betType='" + betType + '\'' +
				", upcoming=" + upcoming +
				'}';
	}
}
