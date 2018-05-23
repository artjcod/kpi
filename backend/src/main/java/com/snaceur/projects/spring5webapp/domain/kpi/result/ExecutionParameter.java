package com.snaceur.projects.spring5webapp.domain.kpi.result;


import com.snaceur.projects.spring5webapp.domain.kpi.model.AuditableBase;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude={"queryOperationResult"},callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ExecutionParameter extends AuditableBase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;
    
    @NotNull @Column(name="NAME",nullable = false)
    private String name;

    @NotNull @Column(name="VALUE",nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "queryOperationResult_id")
    private QueryOperationResult queryOperationResult;

}