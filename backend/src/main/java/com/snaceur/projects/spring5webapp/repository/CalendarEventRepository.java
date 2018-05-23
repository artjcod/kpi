package com.snaceur.projects.spring5webapp.repository;

import com.snaceur.projects.spring5webapp.domain.calendar.CalendarEvent;

import org.springframework.data.repository.CrudRepository;

public interface CalendarEventRepository extends CrudRepository<CalendarEvent,Integer> {

}