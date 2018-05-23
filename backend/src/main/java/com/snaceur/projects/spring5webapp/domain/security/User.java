package com.snaceur.projects.spring5webapp.domain.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "USER")
@Scope("session")
public class User {

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Id
	@Column(name="USERNAME",unique = true,nullable = false)
	@Length(min=5,max=10)
	private  String username;
	
	@Column(name = "ENABLED", nullable = false)
	private  boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private  Set<Authorities> authorities = new HashSet<>();

	public User() {
	}
	
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Collection<? extends Authorities> getAuthorities() {
		return authorities;

	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
