package com.snaceur.projects.spring5webapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.snaceur.projects.spring5webapp.domain.calendar.CalendarEvent;
import com.snaceur.projects.spring5webapp.repository.CalendarEventRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    private CalendarEventRepository calendarEventRepository;

    public CalendarController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @GetMapping("/events")
    public List<? extends CalendarEvent> getCalendarEvents() {
        List<CalendarEvent> result = new ArrayList<>();
        calendarEventRepository.findAll().iterator().forEachRemaining(result::add);
         return result;
    }

}