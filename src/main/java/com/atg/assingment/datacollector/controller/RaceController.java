package com.atg.assingment.datacollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atg.assingment.datacollector.model.Race;
import com.atg.assingment.datacollector.service.IRaceService;

@RestController
public class RaceController {
	
	@Autowired
	private IRaceService raceService;
	
	@RequestMapping("/races/{gameId}")
	public List<Race> getRaces(@PathVariable(value = "gameId") String gameId){
		return raceService.getRaces(gameId);
	}
	
	@RequestMapping("/race/{raceId}")
	public String getRace(@PathVariable(value = "raceId") String raceId){
		return raceService.getRaceInfo(raceId);
	}
	

}
