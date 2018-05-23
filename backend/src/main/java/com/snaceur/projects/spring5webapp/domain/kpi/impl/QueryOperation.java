package com.snaceur.projects.spring5webapp.domain.kpi.impl;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKeyOperation;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class QueryOperation extends PerformanceKeyOperation {

    @NotNull
    @Column(name="QUERY" ,nullable = true)
    private String query;
    public QueryOperation() {}

    public QueryOperation(@NotNull String query) {
        this.query = query;
    }

    // Getters ,Setters

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "QueryOperation{" +
                "query='" + query + '\'' +
                ", id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryOperation that = (QueryOperation) o;

        return query != null ? query.equals(that.query) : that.query == null;
    }

    @Override
    public int hashCode() {
        return query != null ? query.hashCode() : 0;
    }
}
