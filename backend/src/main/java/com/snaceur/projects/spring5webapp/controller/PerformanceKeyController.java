package com.snaceur.projects.spring5webapp.controller;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import com.snaceur.projects.spring5webapp.service.PeformanceKeyExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/indicator")
public class PerformanceKeyController {

   private PeformanceKeyExecutionService peformanceKeyExecutionService;

    @Autowired
    public PerformanceKeyController(PeformanceKeyExecutionService peformanceKeyExecutionService) {
        this.peformanceKeyExecutionService = peformanceKeyExecutionService;
    }

    @GetMapping("/list")
    public String getPerformanceKeyList(Model model) {
        model.addAttribute("indicators",peformanceKeyExecutionService.getAllIndicators());
        return "indicatorList";
    }

 
    @GetMapping("/{indicatorId}/operations")
    public String getOperationsByKey(@PathVariable("indicatorId") Integer indicatorId,Model model) {
       PerformanceKey performanceKey = peformanceKeyExecutionService.getPerformanceKey(indicatorId);
         model.addAttribute("performanceKey",performanceKey);
         model.addAttribute("operations", performanceKey.getPerformanceKeyOperations());
        return "list";
    }

   
    @GetMapping(value="/update")
    public PerformanceKey getUpdatedValue() {
        return peformanceKeyExecutionService.testUpdateValue();
    }

    @GetMapping("/{indicatorId}")
    public String getPerformanceKey(@PathVariable("indicatorId") Integer indicatorId,Model model) {
       PerformanceKey performanceKey = peformanceKeyExecutionService.getPerformanceKey(indicatorId);
         model.addAttribute("performanceKey",performanceKey);
        return "performanceIndicator";
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
