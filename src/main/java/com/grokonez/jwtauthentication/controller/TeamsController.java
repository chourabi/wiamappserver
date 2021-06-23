package com.grokonez.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.EmployeeTeams;
import com.grokonez.jwtauthentication.entitys.Teams;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.EmployeeTeamRepository;
import com.grokonez.jwtauthentication.repository.TeamsRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teams")
public class TeamsController {

	
	 @Autowired
	 TeamsRepository teamsRepository;
	 
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 EmployeeTeamRepository employeeTeamRepository;
	 

	 @GetMapping("/list")
	 public List<Teams> getTeams(){
		 return this.teamsRepository.findAll();
	 }
	 
	 @GetMapping("/list-team-employees/{id_team}")
	 public List<EmployeeTeams> getEmployeesTeamsList(@PathVariable(value ="id_team") Long id){
		 List<EmployeeTeams> tmp =  this.employeeTeamRepository.findAll();
		 
		 List<EmployeeTeams> res = new ArrayList<EmployeeTeams>();
		 
		 for(EmployeeTeams et:tmp) {
			 if( et.getTeam().getId() == id ) {
				 res.add(et);
			 }
		 }
		 
		 return res;
		 
	 }
	 
	 
	 
	 @GetMapping("/list/{id}")
	 public Teams getTeams(@PathVariable(value ="id") Long id){
		 return this.teamsRepository.findById(id).get();
	 }
	 
	 
	 @PostMapping("/add")
	 public Teams addNewTeam(@RequestBody() Teams t) {
		 return this.teamsRepository.save(t);
	 }
	 
	 @PostMapping("/update/{id}")
	 public Teams addNewTeam(@PathVariable(value ="id") Long id,@RequestBody() Teams t) {
		 t.setId(id);
		 return this.teamsRepository.save(t);
	 }
	 
	 @GetMapping("/delete/{id}")
	 public void deleteTeam(@PathVariable(value ="id") Long id) {
		 this.teamsRepository.delete(this.teamsRepository.findById(id).get());
		 
	 }
	 
	 
	 @GetMapping("/delete-employee-affect/{id}")
	 public void deleteEmployeeAffectation(@PathVariable(value ="id") Long id) {
		 this.employeeTeamRepository.delete(this.employeeTeamRepository.findById(id).get());
		 
	 }
	 
	 
	 @GetMapping("/affect/{id_user}/{id_team}")
	 public EmployeeTeams affectUserToTeam(@PathVariable(value ="id_user") Long id_user,@PathVariable(value ="id_team") Long id_team ) {
		 Teams t = this.teamsRepository.findById(id_team).get();
		 User u = this.userRepository.findById(id_user).get();
		 
		 EmployeeTeams et = new EmployeeTeams();
		 et.setUser(u);
		 et.setTeam(t);
		 return this.employeeTeamRepository.save(et);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
