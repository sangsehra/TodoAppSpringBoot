package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.POJO.User;
import com.todoapp.todoapp.service.UsersService;
import com.todoapp.todoapp.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", consumes = "application/json", produces = "application/json")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/signup")
    public String createUser(@RequestBody  User user){
      usersService.createUser(user);
      return JwtUtil.generateToken(user.getName());
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody User user){
        return usersService.userlogin(user);
    }

}
