package com.snaceur.projects.spring5webapp.domain.kpi.impl;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;

import javax.persistence.*;


@Entity
public class DataPerformanceKey extends PerformanceKey {

    public  DataPerformanceKey(){}
    public  DataPerformanceKey(String name, String description) {
        this.name=name;
        this.description=description;
    }

}
