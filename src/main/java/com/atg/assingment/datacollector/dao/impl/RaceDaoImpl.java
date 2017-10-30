package com.atg.assingment.datacollector.dao.impl;

import com.atg.assingment.datacollector.ApplicationConstants;
import com.atg.assingment.datacollector.dao.IRaceDao;
import com.atg.assingment.datacollector.model.BetType;
import com.atg.assingment.datacollector.model.CalendarDay;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class RaceDaoImpl implements IRaceDao {

	private static final Logger log = LoggerFactory.getLogger(RaceDaoImpl.class);

	private LoadingCache<String, BetType> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES).build(
			new CacheLoader<String, BetType>() {
				@Override
				public BetType load(String s) throws Exception {
					String url = ApplicationConstants.RACE_API + s;
					HttpHeaders headers = new HttpHeaders();
				    headers.set("User-Agent", "Mozilla/5.0");
				    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
				    ResponseEntity<String> raceString = restTemplate.exchange(url,
			    		HttpMethod.GET, entity, String.class);
					/*String raceString = restTemplate.getForObject(
							url, String.class);*/
					return mapper.readValue(raceString.getBody(), BetType.class);
				}
			}
	);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private ObjectMapper mapper;

	@Override
	public BetType getRaces(String gameId) {
		try {
			return cache.get(gameId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IllegalStateException("Error while fetching data from rest apis");
		}
	}

	@Override
	public String getRaceInfo(String raceId) {
		try {
			String raceInfo = restTemplate.getForObject(
					ApplicationConstants.RACE_INFO_API + raceId , String.class);
			return raceInfo;
		} catch (RestClientException e) {
			log.error(e.getMessage(), e);
			throw new IllegalStateException("Error while fetching data from rest apis");
		}

	}

}
