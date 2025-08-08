package com.example.spring_api_demo;

import com.example.spring_api_demo.model.Project;
import com.example.spring_api_demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringApiDemoApplication implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiDemoApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Initialize the database with some projects
        projectRepository.save(new Project("Project A", LocalDateTime.now()));
        projectRepository.save(new Project("Project B", LocalDateTime.now()));
        projectRepository.save(new Project("Project C", LocalDateTime.now()));

        System.out.println("Database initialized with sample projects.");
        Long count = projectRepository.count();
        System.out.println("Total projects in the database: " + count);
        projectRepository.findAll().forEach(project ->
            System.out.println("Project ID: " + project.getId() + ", Name: " + project.getName() + ", Created At: " + project.getCreatedAt())
        );
    }
}
