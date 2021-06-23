package com.grokonez.jwtauthentication.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.grokonez.jwtauthentication.model.User;


@Entity
@Table(name = "employee_team")

public class EmployeeTeams {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
	@ManyToOne
	@JoinColumn(nullable = true,name="users_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(nullable = true,name="teams_id")
	private Teams team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public EmployeeTeams(Long id, User user, Teams team) {
		super();
		this.id = id;
		this.user = user;
		this.team = team;
	}

	public EmployeeTeams() {
		super();
	}
	
	
	
	
	
}
