package com.snaceur.projects.spring5webapp.bootstrap;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.snaceur.projects.spring5webapp.domain.calendar.CalendarColor;
import com.snaceur.projects.spring5webapp.domain.calendar.CalendarEvent;
import com.snaceur.projects.spring5webapp.domain.calendar.Rendering;
import com.snaceur.projects.spring5webapp.domain.kpi.impl.DataPerformanceKey;
import com.snaceur.projects.spring5webapp.domain.kpi.impl.OperationParameterBase;
import com.snaceur.projects.spring5webapp.domain.kpi.impl.QueryOperation;
import com.snaceur.projects.spring5webapp.domain.kpi.impl.ServiceOperation;
import com.snaceur.projects.spring5webapp.domain.kpi.model.OperationParameter;
import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKeyOperation;
import com.snaceur.projects.spring5webapp.repository.CalendarEventRepository;
import com.snaceur.projects.spring5webapp.repository.PerformanceKeyRepository;
import com.snaceur.projects.spring5webapp.service.PeformanceKeyExecutionService;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PerformanceKeyRepository performanceKeyRepository;
    private CalendarEventRepository calendarEventRepository;

    @Autowired
    public DevBootstrap(PerformanceKeyRepository performanceKeyRepository,
            CalendarEventRepository calendarEventRepository) {
        this.performanceKeyRepository = performanceKeyRepository;
        this.calendarEventRepository = calendarEventRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createFakeData();
        fillCalendar();
    }

    public void createFakeData() {
        PerformanceKey performanceKey = new DataPerformanceKey("TEST" + new Date().getTime(), "free text description");
        PerformanceKeyOperation queryOperation = new QueryOperation("Select * from User");
        OperationParameter operationParameter = new OperationParameterBase("Champ1", "Expression2");
        queryOperation.addOperationParameter(operationParameter);
        performanceKey.addPerformanceKeyOperation(queryOperation);

        PerformanceKeyOperation serviceOperation = new ServiceOperation(PeformanceKeyExecutionService.class.getName(),
                "replaceIndicatorName");
        OperationParameter operationParameter1 = new OperationParameterBase("indicatorId", "1");
        OperationParameter operationParameter2 = new OperationParameterBase("replacementName", "New Name Added Here!");
        serviceOperation.addOperationParameter(operationParameter1);
        serviceOperation.addOperationParameter(operationParameter2);
        performanceKey.addPerformanceKeyOperation(serviceOperation);

        performanceKeyRepository.save(performanceKey);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void fillCalendar() {

        String[] titles={"Calculate fees","Send Invoices","Generate Invoices","Download list of invoices",
        "Call Clients","Generate bills","Setup Server","Stop Server",
        "Start deployments","Update Maven","Update Central","Update Repositories","Learn Spring 5","Learn Angular 5"};

        Arrays.asList(titles).parallelStream().forEach(title -> {
            List<CalendarColor> calendarColors = Collections.unmodifiableList(Arrays.asList(CalendarColor.values()));
            Random random = new Random();
            CalendarColor calendarColor;
            Integer daysNumber = RandomUtils.nextInt(1, 4);
            Integer daysNumber1 =  RandomUtils.nextInt(1, 6);

            do {
                calendarColor = calendarColors.get(random.nextInt(calendarColors.size()));
            } while (calendarColor.equals(CalendarColor.WHITE));
            CalendarEvent event = new CalendarEvent();
            event.setTitle(title);
            LocalDateTime startDate= LocalDateTime.now().plusDays(daysNumber);
            event.setStart(startDate);
            event.setEnd(startDate.plusHours(daysNumber1).plusMinutes(daysNumber1));
            event.setEditable(true);
            event.setStartEditable(true);
            event.setDurationEditable(true);
            event.setRendering(Rendering.nothing);
            event.setOverlap(false);
            event.setColor(calendarColor.getHexCode());
            event.setTextColor(CalendarColor.WHITE.getHexCode());
            calendarEventRepository.save(event);
        });
        
    }

}