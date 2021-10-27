package com.pratikpatil.userservice.controller;

import com.pratikpatil.userservice.VO.ResponseTempVO;
import com.pratikpatil.userservice.entity.User;
import com.pratikpatil.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside user save method of user controller");
        return userService.save(user);
    }


    @GetMapping("/{id}")
    public ResponseTempVO getUserWithDepartment(@PathVariable("id") Long id){
        log.info("Inside user getUserWithDepartment method of user controller");
        return userService.getUserWithDepartment(id);
    }
}
