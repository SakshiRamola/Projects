package com.atg.assingment.datacollector.dao.impl;

import com.atg.assingment.datacollector.ApplicationConstants;
import com.atg.assingment.datacollector.model.CalendarDay;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author nimag
 */
@RunWith(MockitoJUnitRunner.class)
public class CalendarDaoImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private CalendarDaoImpl calendarDao;

    @Before
    public void setUp() throws IOException{
        CalendarDay calendarDay = new CalendarDay();
        calendarDay.setGames(new HashMap<>());
        when(restTemplate.getForObject(
            ApplicationConstants.CALENDAR_API , String.class)).thenReturn("TEST");
       when(objectMapper.readValue("TEST", CalendarDay.class)).thenReturn(calendarDay);
    }

    @Test
    public void getAllGameTypesForDay() throws Exception {
        calendarDao.getAllGameTypesForDay();
        verify(restTemplate).getForObject(
                ApplicationConstants.CALENDAR_API , String.class);
        calendarDao.getAllGameTypesForDay();

    }

}