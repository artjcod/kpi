package com.snaceur.projects.spring5webapp.domain.kpi.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.snaceur.projects.spring5webapp.domain.configuration.KpiConfiguration;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude={"kpiConfigurations","performanceKeyOperations"},callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PerformanceKey extends AuditableBase {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="NAME", nullable=false, unique=true) @NotNull @Length(min=5,max=30)
    protected String name;

    @Column(name="DESCRIPTION")
    protected String description;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "performanceKey_id")
    protected Set<PerformanceKeyOperation> performanceKeyOperations=new HashSet<PerformanceKeyOperation>();

    @JsonIgnore
    @ManyToMany(mappedBy = "performanceKeys",fetch=FetchType.LAZY)
    private Set<KpiConfiguration> kpiConfigurations=new HashSet<KpiConfiguration>();

    // Operations

    public void addPerformanceKeyOperation(PerformanceKeyOperation performanceKeyOperation) {
        this.performanceKeyOperations.add(performanceKeyOperation);
       performanceKeyOperation.setPerformanceKey(this);
    }
    public void removePerformanceKeyOperation(PerformanceKeyOperation performanceKeyOperation) {
        this.performanceKeyOperations.remove(performanceKeyOperation);
    }

}