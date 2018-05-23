package com.snaceur.projects.spring5webapp.domain.kpi.result;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=false, exclude={"executionParameter","performanceKey"})
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class QueryOperationResult extends OperationResult{

    @NotNull
    @Column(name="PERFORMANCEKEY",nullable = false)
    private String performanceKey;

    @NotNull
    @Column(name="QUERY")
    private  String query;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "queryOperationResult_id")
    private Set<ExecutionParameter> executionParameter=new HashSet<ExecutionParameter>();


    // Operations

   public void addExecutionParameter(ExecutionParameter executionParameter) {
       executionParameter.setQueryOperationResult(this);
        this.executionParameter.add(executionParameter);
    }
    public void removeExecutionParameter(ExecutionParameter executionParameter) {
        this.executionParameter.remove(executionParameter);
    }
}
