package com.snaceur.projects.spring5webapp.domain.kpi.impl;

import com.snaceur.projects.spring5webapp.domain.kpi.model.PerformanceKeyOperation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class ServiceOperation extends PerformanceKeyOperation {

    @NotNull
    @Column(name="SERVICENAME",nullable = true)
    private String serviceName;

    @NotNull
    @Column(name="METHOD",nullable = true)
    private String method;

    public ServiceOperation(@NotNull String serviceName,@NotNull String method) {
        this.serviceName = serviceName;
        this.method = method;
    }

    public ServiceOperation() {}
    public String getServiceName() {
        return serviceName;
    }

    public String getServiceShortName() throws ClassNotFoundException {
        return Class.forName(this.serviceName).getSimpleName();
    }
     

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceOperation)) return false;

        ServiceOperation that = (ServiceOperation) o;

        if (!serviceName.equals(that.serviceName)) return false;
        return method.equals(that.method);
    }

    @Override
    public int hashCode() {
        int result = serviceName.hashCode();
        result = 31 * result + method.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ServiceOperation{" +
                "serviceName='" + serviceName + '\'' +
                ", method='" + method + '\'' +
                ", id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
