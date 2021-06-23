package com.grokonez.jwtauthentication.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "projectfiles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","project"})
public class ProjectFiles {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
 
    private String url;
    
    
	@ManyToOne
	@JoinColumn(nullable = true,name="projects_id")
	private Projects project;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Projects getProject() {
		return project;
	}


	public void setProject(Projects project) {
		this.project = project;
	}


	public ProjectFiles(Long id, String url, Projects project) {
		super();
		this.id = id;
		this.url = url;
		this.project = project;
	}
	
	public ProjectFiles() {
		super();
	}
	
}
