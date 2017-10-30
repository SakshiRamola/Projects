package com.atg.assingment.datacollector.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atg.assingment.datacollector.dao.ICalendarDao;
import com.atg.assingment.datacollector.service.ICalendarService;

@Service
public class CalendarServiceImpl implements ICalendarService{
	
	@Autowired 
	private ICalendarDao calendarDao;

	@Override
	public List<String> getAllGameTypesForDay() {
		
		try {
			return calendarDao.getAllGameTypesForDay();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
