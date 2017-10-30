package com.atg.assingment.datacollector.controller;

import com.atg.assingment.datacollector.exception.ServerException;
import com.atg.assingment.datacollector.model.Race;
import com.atg.assingment.datacollector.service.IRaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RaceController {

	private static final Logger log = LoggerFactory.getLogger(RaceController.class);
	
	@Autowired
	private IRaceService raceService;

	/**
	 * RestEndpoint for getting all races for a given betType
	 * Example url : http://localhost:8080/races/V3
	 *
	 * @param gameId
	 * @return
	 * @throws ServerException
	 */
	@RequestMapping("/races/{gameId}")
	public List<Race> getRaces(@PathVariable(value = "gameId") String gameId) throws ServerException {
		try {
			return raceService.getRaces(gameId);
		} catch (Exception e) {
			log.error("Error while fetching races for bettype" + gameId, e);

			// Not using checked exception in service and DAO layer as it pollutes the code. However at the Facade level
			// i.e. controller cataching everything and throwing up generic checked exception for clients
			throw new ServerException(e);
		}
	}

	/**
	 * RestEndpoint for getting race info for a given race id
	 * Example url : http://localhost:8080/race/V3_2017-10-30_9_7
	 *
	 * @param raceId
	 * @return
	 * @throws ServerException
	 */
	@RequestMapping("/race/{raceId}")
	public String getRace(@PathVariable(value = "raceId") String raceId) throws ServerException {
		try {
			return raceService.getRaceInfo(raceId);
		} catch (Exception e) {
			log.error("Error while fetching race info for race with id " + raceId, e);

			// Not using checked exception in service and DAO layer as it pollutes the code. However at the Facade level
			// i.e. controller cataching everything and throwing up generic checked exception for clients
			throw new ServerException(e);
		}
	}
	

}
