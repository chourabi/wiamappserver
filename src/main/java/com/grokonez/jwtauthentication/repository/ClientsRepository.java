package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Clients;

public interface ClientsRepository extends JpaRepository<Clients,Long> {

}
