package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Projects;
import com.grokonez.jwtauthentication.entitys.Teams;
import com.grokonez.jwtauthentication.message.request.NewProjectAddRequest;
import com.grokonez.jwtauthentication.repository.ClientsRepository;
import com.grokonez.jwtauthentication.repository.ProjectsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

	@Autowired
	ProjectsRepository projectsRepository;
	
	@Autowired
	ClientsRepository clientssRepository;
	
	 @GetMapping("/list")
	 public List<Projects> getProjectslist(){
		 return this.projectsRepository.findAll();
	 }
	 
	 @GetMapping("/list/{id}")
	 public Projects getProject(@PathVariable(value ="id") Long id ){
		 return this.projectsRepository.findById(id).get();
	 }
	 
	 
	 @PostMapping("/add")
	 public Projects addNewProject(@RequestBody() NewProjectAddRequest np) {
		 Projects p =new Projects();
		 p.setName(np.getName());
		 p.setActivity(np.getActivity());
		 p.setClient(this.clientssRepository.findById(np.getClientId()).get());
		 p.setCountry(np.getCountry());
		 p.setStart_date(np.getStart_date());
		 if( np.getStart_date().equals("") ) {
			 p.setEnd_date(null);
		 }else {
			 p.setEnd_date(np.getEnd_date());
		 }
		 
		 
		 
		 
		 
		 return this.projectsRepository.save(p);
	 }
	 

	
}
