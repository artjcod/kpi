package com.snaceur.projects.spring5webapp.domain.kpi.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude={"performanceKey"},callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PerformanceKeyOperation extends AuditableBase {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @ManyToOne
    @JoinColumn(name = "performanceKey_id")
    private PerformanceKey performanceKey;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "performanceKeyOperation_id")
    private Set<OperationParameter> operationParameters=new HashSet<OperationParameter>();

    public void addOperationParameter(OperationParameter operationParameter) {
        this.operationParameters.add(operationParameter);
        operationParameter.setPerformanceKeyOperation(this);
    }
    public void removeOperationParameter(OperationParameter operationParameter) {
        this.operationParameters.remove(operationParameter);
    }
    
}
