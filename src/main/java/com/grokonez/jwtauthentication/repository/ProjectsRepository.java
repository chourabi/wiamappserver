package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Projects;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {

}
