package com.atg.assingment.datacollector.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.atg.assingment.datacollector.dao.ICalendarDao;
import com.atg.assingment.datacollector.model.CalendarDay;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CalendarDaoImpl implements ICalendarDao{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<String> getAllGameTypesForDay() throws JsonParseException, JsonMappingException, IOException {
		String calendarDay = restTemplate.getForObject(
				"https://www.atg.se/services/racinginfo/v1/api/calendar/day", String.class);
		CalendarDay day = objectMapper.readValue(calendarDay, CalendarDay.class);
		return new ArrayList<String>(day.getGames().keySet());
	}

	
	
}
