package com.snaceur.projects.spring5webapp.service;

import java.util.List;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import com.snaceur.projects.spring5webapp.repository.PerformanceKeyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeformanceKeyExecutionService {

    private PerformanceKeyRepository performanceKeyRepository;

    @Autowired
    public PeformanceKeyExecutionService(PerformanceKeyRepository performanceKeyRepository) {
        this.performanceKeyRepository = performanceKeyRepository;
    }

    public PerformanceKey testUpdateValue() {
        PerformanceKey performanceKey = performanceKeyRepository.findById(11);
        performanceKey.setName("Hi Hello");
        performanceKey.getPerformanceKeyOperations().clear();
        performanceKeyRepository.save(performanceKey);
        return performanceKey;
    }

    public List<PerformanceKey> getAllIndicators() {
        return performanceKeyRepository.findAll();
    }

    public PerformanceKey getPerformanceKey(Integer indicatorId) {
        return performanceKeyRepository.findById(indicatorId);
    }

    public void replaceIndicatorName(Integer indicatorId, String replacementName) {
        PerformanceKey performanceKey = performanceKeyRepository.findById(indicatorId);
        performanceKey.setName(replacementName);
        performanceKeyRepository.save(performanceKey);
        log.info("Value Updated");
    }
}
