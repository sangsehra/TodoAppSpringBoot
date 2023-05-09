package com.todoapp.todoapp.service;

import com.todoapp.todoapp.Entities.Users;
import com.todoapp.todoapp.POJO.User;
import com.todoapp.todoapp.Repository.UserRepository;
import com.todoapp.todoapp.utils.PasswordUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordUtil passwordUtil;
    public void createUser(User user){
        Users userEntity = createUserEntity(user);
        userRepository.save(userEntity);
        log.info("user created");
    }

    public Users createUserEntity(User user){
        Users userRequest = new Users();
        userRequest.setName(user.getName());
        userRequest.setPassword(passwordUtil.encryptPassword(user.getPassword()));
        return userRequest;
    }

    public String userlogin(User user){
        Users existingUser = userRepository.getUsersByName(user.getName()).get();
        if(passwordUtil.passwordChecker(existingUser.getPassword(),user.getPassword())){
            return "user Logged-in";
        }
        return "Log-in failed";
    }
}
