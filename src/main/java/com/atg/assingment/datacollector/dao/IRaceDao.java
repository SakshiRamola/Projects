package com.atg.assingment.datacollector.dao;

import java.io.IOException;

import com.atg.assingment.datacollector.model.BetType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IRaceDao {
	
	BetType getRaces(String gameId) throws JsonParseException, JsonMappingException, IOException ;

	String getRaceInfo(String raceId) throws JsonParseException, JsonMappingException, IOException ;

}
