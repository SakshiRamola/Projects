package com.atg.assingment.datacollector.service.impl;

import com.atg.assingment.datacollector.dao.ICalendarDao;
import com.atg.assingment.datacollector.service.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CalendarServiceImpl implements ICalendarService{
	
	@Autowired 
	private ICalendarDao calendarDao;

	@Override
	public Set<String> getAllGameTypesForDay() {
		return calendarDao.getAllGameTypesForDay();
	}

}
