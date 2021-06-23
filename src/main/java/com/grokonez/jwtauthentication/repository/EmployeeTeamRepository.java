package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.EmployeeTeams;

public interface EmployeeTeamRepository extends JpaRepository<EmployeeTeams,Long> {

}
