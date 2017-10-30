package com.atg.assingment.datacollector.controller;

import com.atg.assingment.datacollector.exception.ServerException;
import com.atg.assingment.datacollector.service.ICalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CalendarController {

	private static final Logger log = LoggerFactory.getLogger(CalendarController.class);
	
	@Autowired 
	private ICalendarService calendarService;

	/**
	 * RestEndpoint for getting all BetType available today.
	 * Example URL : http://localhost:8080/gameType
	 *
	 * @return
	 * @throws ServerException
	 */
	@RequestMapping("/gameType")
	public Set<String> gameType() throws ServerException {
		try {
			return calendarService.getAllGameTypesForDay();
		}catch (Exception e) {
			log.error("Error while fetching all gameType", e);

			// Not using checked exception in service and DAO layer as it pollutes the code. However at the Facade level
			// i.e. controller catching everything and throwing up generic checked exception for clients
			throw new ServerException(e);
		}
	}

}
