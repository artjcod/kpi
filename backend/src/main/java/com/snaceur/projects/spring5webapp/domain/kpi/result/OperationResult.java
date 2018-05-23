package com.snaceur.projects.spring5webapp.domain.kpi.result;

import com.snaceur.projects.spring5webapp.domain.kpi.model.AuditableBase;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper=false, exclude={"metrics"})
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class OperationResult extends AuditableBase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="VALID",nullable = false)
    @NotNull
    protected Boolean valid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OperationResult_id")
    private Set<Metric> metrics=new HashSet<Metric>();

    //Operations

    public void addMetrics(Metric metric) {
        metric.setOperationResult(this);
        this.metrics.add(metric);
    }

    public void removeMetrics(Metric metric) {
        this.metrics.remove(metric);
    }
}

