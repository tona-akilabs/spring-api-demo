package com.example.spring_api_demo.request;

import com.example.spring_api_demo.validation.UniqueProject;
import jakarta.validation.constraints.NotBlank;


public class ProjectCreation {
    @NotBlank(message = "projectName is required")
    @UniqueProject(message = "projectName already exists")
    private String name;

    public ProjectCreation() {}

    public ProjectCreation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
