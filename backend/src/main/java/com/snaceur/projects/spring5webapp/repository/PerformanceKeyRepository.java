package com.snaceur.projects.spring5webapp.repository;


import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface  PerformanceKeyRepository extends Repository<PerformanceKey,Integer> {


    @Transactional(readOnly = true)
    PerformanceKey findById(Integer id);

    @Transactional(readOnly = true)
    @Query("select p from PerformanceKey p")
    List<PerformanceKey> findAll();

    void save(PerformanceKey performanceKey);

}