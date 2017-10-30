package com.atg.assingment.datacollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atg.assingment.datacollector.service.ICalendarService;

@RestController
public class CalendarController {
	
	@Autowired 
	private ICalendarService calendarService;
	
	@RequestMapping("/gameType")
	public List<String> gameType(){
		return calendarService.getAllGameTypesForDay();
	}

}
