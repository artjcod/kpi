package com.snaceur.projects.spring5webapp.domain.security;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

	@Id
	@Column(name = "AUTHORITY")
	@Length(max=100)
	private String authority;

	@ManyToOne
	@JoinColumn(name = "USERNAME",columnDefinition = "varchar(10)")
	private User user;

	public String getAuthority() {
		return authority;
	}
	
}
