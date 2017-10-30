package com.atg.assingment.datacollector.dao.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.atg.assingment.datacollector.dao.IRaceDao;
import com.atg.assingment.datacollector.model.BetType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class RaceDaoImpl implements IRaceDao {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private ObjectMapper mapper;

	@Override
	public BetType getRaces(String gameId) throws JsonParseException, JsonMappingException, IOException {
		String url = "https://www.atg.se/services/racinginfo/v1/api/products/"+ gameId;
		String raceString = restTemplate.getForObject(
				url, String.class);
		return mapper.readValue(raceString, BetType.class);
	}

	@Override
	public String getRaceInfo(String raceId) throws JsonParseException,
			JsonMappingException, IOException {
		String raceInfo = restTemplate.getForObject(
				"https://www.atg.se/services/racinginfo/v1/api/games/" + raceId , String.class);
		return raceInfo;
	}

}
