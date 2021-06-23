package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Clients;
import com.grokonez.jwtauthentication.entitys.Teams;
import com.grokonez.jwtauthentication.repository.ClientsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientsController {

	
	@Autowired
	ClientsRepository clientsRepository;
	

	 @GetMapping("/list")
	 public List<Clients> getTeams(){
		 return this.clientsRepository.findAll();
	 }
	 
	 @PostMapping("/add")
	 public Clients addNewTeam(@RequestBody() Clients c) {
		 return this.clientsRepository.save(c);
	 }
}
