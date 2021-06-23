package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.ProjectFiles;

public interface ProjectFilesRepository extends JpaRepository<ProjectFiles,Long> {

}
