package com.grokonez.jwtauthentication.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.TeamsProject;
import com.grokonez.jwtauthentication.message.request.TeamAffectProject;
import com.grokonez.jwtauthentication.repository.ProjectsRepository;
import com.grokonez.jwtauthentication.repository.TeamsProjectRepository;
import com.grokonez.jwtauthentication.repository.TeamsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teams-project")
public class TeamsProjectController {
	
	
	@Autowired
	TeamsRepository teamsRepository;
	
	@Autowired
	ProjectsRepository projectsRepository;
	
	@Autowired
	TeamsProjectRepository teamProjectRepository;
	
	@GetMapping("/list/{id_project}")
	public List<TeamsProject> getProjectTeams(@PathVariable(value ="id_project") Long id){
		List<TeamsProject> all= this.teamProjectRepository.findAll();
		List<TeamsProject> res = new ArrayList<TeamsProject>();
		
		for(TeamsProject p:all) {
			if( p.getProject().getId() == id ) {
				res.add(p);
			}
		}
		
		return res;
		
		
	}
	
	
	@GetMapping("/delete/{id_affectation}")
	public void deleteTeamAffectation(@PathVariable(value ="id_affectation") Long id){
		TeamsProject d = this.teamProjectRepository.findById(id).get();
		
		this.teamProjectRepository.delete(d);
		
		
	}
	
	@PostMapping("/add")
	public TeamsProject affectTeam(@RequestBody TeamAffectProject t) {
		TeamsProject tp = new TeamsProject();
		
		tp.setProject(this.projectsRepository.findById(t.getId_project()).get());
		tp.setTeam(this.teamsRepository.findById(t.getId_team()).get());
		
		
		return this.teamProjectRepository.save(tp);
	}
	

}
