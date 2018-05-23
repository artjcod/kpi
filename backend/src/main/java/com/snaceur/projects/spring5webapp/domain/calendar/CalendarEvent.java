package com.snaceur.projects.spring5webapp.domain.calendar;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import com.snaceur.projects.spring5webapp.domain.kpi.model.AuditableBase;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(AuditingEntityListener.class)
public class CalendarEvent extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // String. Required. The text on an event's element 

    @NotNull
    @Column(nullable = false)
    private String title;

    /**
     * Whether an event occurs at a specific time-of-day. 
     * This property affects whether an event's time is shown. 
     * Also, in the agenda views, determines if it is displayed in the "all-day" section.
     * If this value is not explicitly specified, allDayDefault will be used if it is defined. 
     * If all else fails, FullCalendar will try to guess. 
     * If either the start or end value has a "T" as part of the ISO8601 date string, 
     * allDay will become false. Otherwise, it will be true. 
     * Don't include quotes around your true/false. This value is a boolean, not a string! 
     */
    @Column(nullable = false)
    private boolean allDay;

    /**
     * The date/time an event begins. Required. A Moment-ish input, like an ISO8601 string. 
     * Throughout the API this will become a real Moment object. 
     */
    @NotNull
    @Column(nullable = false)
    private LocalDateTime start;

    /**
     * The exclusive date/time an event ends. Optional. 
     * A Moment-ish input, like an ISO8601 string. 
     * Throughout the API this will become a real Moment object. 
     * It is the moment immediately after the event has ended. For example, 
     * if the last full day of an event is Thursday, 
     * the exclusive end of the event will be 00:00:00 on Friday! 
     */

    @Column(nullable = true)
    private LocalDateTime end;

    //A URL that will be visited when this event is clicked by the user

    @Column(nullable = true)
    private String url;

    /**
     * String/Array. Optional. 
     * A CSS class (or array of classes) that will be attached to this event's element.
     */
    @Lob
    @Column(nullable = true)
    private String className;

    //Determines whether the events on the calendar can be modified.

    @Column(nullable = false)
    private boolean editable;

    //Allow events’ start times to be editable through dragging.
  
    @Column(nullable = false)
    private boolean startEditable;

    // Allow events’ durations to be editable through resizing.

    @Column(nullable = false)
    private boolean durationEditable;

   // Determines whether the user can drag events between resources.

    @Column(nullable = false)
    private boolean resourceEditable;

    //Events that appear as background highlights 

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable=false)
    private Rendering rendering;

    //Determines if events being dragged and resized are allowed to overlap each other.

    @Column(nullable = false)
    private boolean overlap;

    //Sets an event's background and border color
    private String color;
    private String  backgroundColor;
    private String  borderColor;
    private String  textColor;

}