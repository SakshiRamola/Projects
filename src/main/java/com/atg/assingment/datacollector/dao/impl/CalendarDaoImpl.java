package com.atg.assingment.datacollector.dao.impl;

import com.atg.assingment.datacollector.ApplicationConstants;
import com.atg.assingment.datacollector.dao.ICalendarDao;
import com.atg.assingment.datacollector.model.CalendarDay;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class CalendarDaoImpl implements ICalendarDao{

	private static final Logger log = LoggerFactory.getLogger(CalendarDaoImpl.class);

	private static final String DUMMY_KEY = "DUMMY_KEY";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	private LoadingCache<String, Set<String>> cache = CacheBuilder.newBuilder().refreshAfterWrite(10, TimeUnit.MINUTES).build(
			new CacheLoader<String, Set<String>>() {
				@Override
				public Set<String> load(String s) throws Exception {
					String calendarDay = restTemplate.getForObject(
							ApplicationConstants.CALENDAR_API , String.class);
					CalendarDay day = objectMapper.readValue(calendarDay, CalendarDay.class);
					return day.getGames().keySet();
				}
			}
	);

	@Override
	public Set<String> getAllGameTypesForDay(){
		try {
			return cache.get(DUMMY_KEY) ;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IllegalStateException("Error while fetching data from rest apis");
		}
	}

	
	
}
