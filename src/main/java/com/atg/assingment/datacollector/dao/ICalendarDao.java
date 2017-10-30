package com.atg.assingment.datacollector.dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ICalendarDao {
	
	public List<String> getAllGameTypesForDay() throws JsonParseException, JsonMappingException, IOException ;
}
