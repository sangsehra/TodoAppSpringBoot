package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.POJO.User;
import com.todoapp.todoapp.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", consumes = "application/json")
@AllArgsConstructor
@NoArgsConstructor
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public void createUser(@RequestBody  User user){
      usersService.createUser(user);
    }

    @PostMapping("/login")
    public String userLogin(User user){
        return usersService.userlogin(user);
    }

}
