package com.snaceur.projects.spring5webapp.domain.kpi.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;

@MappedSuperclass
public abstract class AuditableBase implements Auditable<String,Integer,LocalDateTime> {

  
    @CreatedBy
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;


    @Override
     public Optional<String> getCreatedBy() {
         return Optional.ofNullable(this.createdBy);
     }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
     public Optional<LocalDateTime> getCreatedDate() {
         return null == createdDate ? Optional.empty()
                 : Optional.of(LocalDateTime.ofInstant(createdDate.toInstant(), ZoneId.systemDefault()));
     }
 

     @Override
     public Optional<String> getLastModifiedBy() {
		return Optional.ofNullable(lastModifiedBy);
     }


   
     @Override
	public Optional<LocalDateTime> getLastModifiedDate() {
		return null == lastModifiedDate ? Optional.empty()
				: Optional.of(LocalDateTime.ofInstant(lastModifiedDate.toInstant(), ZoneId.systemDefault()));
	}

     
     public void setCreatedBy(String createdBy) {
         this.createdBy = createdBy;
     }

     public void setCreatedDate(LocalDateTime creationDate) {
		this.createdDate = Date.from(creationDate.atZone(ZoneId.systemDefault()).toInstant());
     }

  
     public void setLastModifiedBy(String lastModifiedBy) {
         this.lastModifiedBy = lastModifiedBy;
     }

     public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = Date.from(lastModifiedDate.atZone(ZoneId.systemDefault()).toInstant());
     }

     @Override
     public boolean isNew() {
         return null == getId();
     }

}