package com.atg.assingment.datacollector.service;

import java.util.List;

import com.atg.assingment.datacollector.model.Race;

public interface IRaceService {

	List<Race> getRaces(String gameId);
	
	String getRaceInfo(String raceId);
}
