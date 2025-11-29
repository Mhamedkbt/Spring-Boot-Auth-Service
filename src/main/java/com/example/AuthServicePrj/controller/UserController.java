package com.example.AuthServicePrj.controller;

import com.example.AuthServicePrj.model.User;
import com.example.AuthServicePrj.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
   this.userService = userService;
  }

  @GetMapping("/me")
    public ResponseEntity<User> authenticationUser(){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      User currentUser = (User) authentication.getPrincipal();
      return ResponseEntity.ok(currentUser);
  }

  @PostMapping("/")
    public ResponseEntity<List<User>> allUsers(){
      List<User> users = userService.allUsers();
      return ResponseEntity.ok(users);
  }
}




















