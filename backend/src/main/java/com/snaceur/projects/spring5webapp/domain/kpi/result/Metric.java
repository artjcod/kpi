package com.snaceur.projects.spring5webapp.domain.kpi.result;

import com.snaceur.projects.spring5webapp.domain.kpi.model.AuditableBase;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude={"operationResult"},callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Metric extends AuditableBase {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;
    
    private @NotNull @Column(name = "NAME" ,nullable=false) String name;
    private @NotNull @Column(name="VALUE") String value;

    @ManyToOne
    @JoinColumn(name = "operationResult_id")
    private OperationResult operationResult;

    @NotNull
    private MetricReturnType type;

}

