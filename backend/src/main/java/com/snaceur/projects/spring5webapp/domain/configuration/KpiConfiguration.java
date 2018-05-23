package com.snaceur.projects.spring5webapp.domain.configuration;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKey;
import com.snaceur.projects.spring5webapp.domain.security.User;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KpiConfiguration extends AbstractAuditable<User,Integer> {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true,nullable = false)
    private String name;

    private @Nullable String description;

    @ManyToMany
            @JoinTable(name = "performanceKey_kpiConfiguration", joinColumns = @JoinColumn(name = "kpiConfiguration_id")
            ,inverseJoinColumns = @JoinColumn(name = "performanceKey_id"))

    Set<PerformanceKey> performanceKeys=new HashSet<PerformanceKey>();

    public void addPerformanceKey(PerformanceKey performanceKey) {
        this.performanceKeys.add(performanceKey);
    }

    public void removePerformanceKey(PerformanceKey performanceKey) {
        this.performanceKeys.remove(performanceKey);
    }

}
