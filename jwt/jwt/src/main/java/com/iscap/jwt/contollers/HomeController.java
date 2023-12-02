package com.iscap.jwt.contollers;

import com.iscap.jwt.model.User;
import com.iscap.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RequestMapping("/home")
@RestController
public class HomeController {

    @Autowired
    public UserService userservice;
    @GetMapping("/users")
    public List<User> getUser(){
        return userservice.getUsers();
    }
    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
