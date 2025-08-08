package com.example.spring_api_demo.repository;

import com.example.spring_api_demo.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    boolean existsByName(String name);
}
