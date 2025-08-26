package com.example.spring_api_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/v1/asyn")
public class SimpleAsynController {

    @GetMapping
    public Callable<String> processUpload() {
        return () -> "someView";
    }

    /*@PostMapping
    public Callable<String> processUpload(final MultipartFile file) {
        return () -> "someView";
    }*/

    @GetMapping("/callable")
    WebAsyncTask<String> handle() {
        return new WebAsyncTask<String>(20000L,()->{
            Thread.sleep(10000); //simulate long-running task
            return "asynchronous request completed";
        });
    }
}
