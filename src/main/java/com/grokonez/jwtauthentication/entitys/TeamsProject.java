package com.grokonez.jwtauthentication.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams_project")
public class TeamsProject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
	@JoinColumn(nullable = true,name="teams_id")
	private Teams team;
	
	@ManyToOne
	@JoinColumn(nullable = true,name="projects_id")
	private Projects project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	public TeamsProject(Long id, Teams team, Projects project) {
		super();
		this.id = id;
		this.team = team;
		this.project = project;
	}

	public TeamsProject() {
		super();
	}
	
	
	
	
}
