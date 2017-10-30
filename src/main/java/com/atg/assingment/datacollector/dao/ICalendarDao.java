package com.atg.assingment.datacollector.dao;

import java.util.Set;

public interface ICalendarDao {

	/**
	 *  Makes a request to ATG calendar APi (https://www.atg.se/services/racinginfo/v1/api/calendar/day)
	 *  and returns all Bettype available for today.
	 * @return Set containing name of the BetTypes running today
	 */
	Set<String> getAllGameTypesForDay();
}