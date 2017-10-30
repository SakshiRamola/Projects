package com.atg.assingment.datacollector.dao;

import com.atg.assingment.datacollector.model.BetType;

public interface IRaceDao {

	/**
	 * Fetches all upcoming races for given gameid / Bet type
	 * @param gameId
	 * @return BetType object containing all upcoming races
	 */
	BetType getRaces(String gameId);


	/**
	 * Fetches all the info for the race corresponding to given RaceID.
	 * @param raceId
	 * @return
	 */
	String getRaceInfo(String raceId);

}
