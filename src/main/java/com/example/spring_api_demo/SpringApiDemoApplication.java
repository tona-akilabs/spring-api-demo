package com.example.spring_api_demo;

import com.example.spring_api_demo.model.Project;
import com.example.spring_api_demo.repository.ProjectRepository;
import com.example.spring_api_demo.request.ProductRequest;
import com.example.spring_api_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringApiDemoApplication implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProductService productService;

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

        List<String> productsInfo = Arrays.asList(
                productService.createProduct(new ProductRequest("Iphone 15", 999.99)),
                productService.createProduct(new ProductRequest("Samsung Galaxy S23", 899.99))
                // ,productService.createProduct(new ProductRequest("", null))
        );
        productsInfo.forEach(System.out::println);
        System.out.println("Products created successfully.");
    }
}
