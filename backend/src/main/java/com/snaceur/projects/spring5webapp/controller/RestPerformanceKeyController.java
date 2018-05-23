package com.snaceur.projects.spring5webapp.controller;
import java.util.List;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import com.snaceur.projects.spring5webapp.repository.PerformanceKeyRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestPerformanceKeyController {

     private PerformanceKeyRepository performanceKeyRepository;

      public RestPerformanceKeyController (PerformanceKeyRepository performanceKeyRepository) {
          this.performanceKeyRepository = performanceKeyRepository;
      }

      @GetMapping("/api/indicators")
    public List<PerformanceKey> getPerformanceKeys() {
       return performanceKeyRepository.findAll();
    }
}