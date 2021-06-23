package com.grokonez.jwtauthentication.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Clients {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Size(min=3, max = 250)
    private String name;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Clients(Long id, @Size(min = 3, max = 250) String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Clients() {
		super();
	}
	
	
	
}
