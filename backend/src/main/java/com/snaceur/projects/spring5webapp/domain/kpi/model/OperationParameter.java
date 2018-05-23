package com.snaceur.projects.spring5webapp.domain.kpi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude={"performanceKeyOperation"},callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class OperationParameter extends AuditableBase {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @ManyToOne
    @JoinColumn(name = "performanceKeyOperation_id")
    private PerformanceKeyOperation performanceKeyOperation;
 
}
