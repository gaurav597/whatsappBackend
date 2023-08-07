package com.project.backend.controller;

import com.project.backend.entity.User;
import com.project.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class restController
{
    @Autowired
    public UserService userService;
    @GetMapping( path="/get")
    public ResponseEntity<String> firstApiCall(){
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }

    @PostMapping(path ="/postMessage")
    public ResponseEntity<String> getMessage(@RequestBody String message, String answer){
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        System.out.println(user);
        userService.addUser(user);
        return new ResponseEntity<>("UserAdded", HttpStatus.OK);
    }

}
