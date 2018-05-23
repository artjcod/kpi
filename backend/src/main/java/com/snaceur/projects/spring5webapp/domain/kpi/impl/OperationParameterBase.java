package com.snaceur.projects.spring5webapp.domain.kpi.impl;


import com.snaceur.projects.spring5webapp.domain.kpi.model.OperationParameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class OperationParameterBase
        extends OperationParameter {

    @NotNull
    @Column(name = "NAME",nullable = false)
    private String name;
    @NotNull
    @Column(name="EXPRESSION",nullable = false)
    private String expression;

    public OperationParameterBase() {
        super();
    }
    public OperationParameterBase(String name, String expression)
    {
        this.name=name;
        this.expression=expression;
    }

    public String getName() {
        return name;
    }

    public String getExpression() {
        return expression;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationParameterBase)) return false;
        if (!super.equals(o)) return false;

        OperationParameterBase that = (OperationParameterBase) o;

        if (!name.equals(that.name)) return false;
        return expression.equals(that.expression);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + expression.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OperationParameterBase{" +
                "name='" + name + '\'' +
                ", expression='" + expression + '\'' +
                ", id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
