package com.atg.assingment.datacollector.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atg.assingment.datacollector.dao.IRaceDao;
import com.atg.assingment.datacollector.model.Race;
import com.atg.assingment.datacollector.service.IRaceService;

@Service
public class RaceServiceImpl implements IRaceService{

	
	@Autowired
	private IRaceDao raceDao;
	@Override
	public List<Race> getRaces(String gameId) {
		return raceDao.getRaces(gameId).getUpcoming();
	}
	@Override
	public String getRaceInfo(String raceId) {
		return raceDao.getRaceInfo(raceId);
	}
}
