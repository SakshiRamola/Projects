package com.atg.assingment.datacollector.service.impl;

import com.atg.assingment.datacollector.dao.ICalendarDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * @author nimag
 */
@RunWith(MockitoJUnitRunner.class)
public class CalendarServiceImplTest {

    @Mock
    private ICalendarDao calendarDao;

    @InjectMocks
    private CalendarServiceImpl calendarService;


    @Test
    public void getAllGameTypesForDay() throws Exception {
        calendarService.getAllGameTypesForDay();
        verify(calendarDao).getAllGameTypesForDay();

    }

}