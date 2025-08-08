package com.example.spring_api_demo.controller;

import com.example.spring_api_demo.request.ProjectCreation;
import com.example.spring_api_demo.model.Project;
import com.example.spring_api_demo.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//@RestController
//@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody @Valid ProjectCreation projectCreation) {
        Project project = new Project(projectCreation.getName(), LocalDateTime.now());
        return projectRepository.save(project);
    }
}
