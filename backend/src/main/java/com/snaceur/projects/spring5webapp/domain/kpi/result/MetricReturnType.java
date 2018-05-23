package com.snaceur.projects.spring5webapp.domain.kpi.result;

import java.util.Date;

public enum MetricReturnType {
    DATE (Date.class.getName()) , INTEGER (Integer.class.getName());
    private String className ;
    MetricReturnType(String className) {
        this.className=className;
    }
  
    public String getClassName() {
        return className;
    }

}
