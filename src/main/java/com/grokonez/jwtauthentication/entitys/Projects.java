package com.grokonez.jwtauthentication.entitys;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 

@Entity
@Table(name = "projects")
public class Projects {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min=3, max = 250)
    private String name;
	
	@Size(min=3, max = 250)
    private String start_date;
	
	@Column(nullable = true)
    private String end_date;
	
	@Size(min=3, max = 250)
    private String country;
	
	@OneToOne
	@JoinColumn(nullable = true,name="clients_id")
	private Clients client;
	
    @OneToMany(mappedBy = "project")
    private Set<ProjectFiles> files;
    
    
    
	
	public Set<ProjectFiles> getFiles() {
		return files;
	}


	public void setFiles(Set<ProjectFiles> files) {
		this.files = files;
	}


	@Size(min=3, max = 2000)
    private String activity;


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


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public Projects(Long id, @Size(min = 3, max = 250) String name, @Size(min = 3, max = 250) String start_date,
			@Size(min = 3, max = 250) String end_date, @Size(min = 3, max = 250) String country, Clients client,
			@Size(min = 3, max = 2000) String activity) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.country = country;
		this.client = client;
		this.activity = activity;
	}


	public Projects() {
		super();
	}
	
	
	
	
	
	

}
