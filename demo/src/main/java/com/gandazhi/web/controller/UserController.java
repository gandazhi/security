package com.gandazhi.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gandazhi.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gandazhi
 * @create 2017-12-17 下午1:58
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    @JsonView(User.userSimple.class)
    public List<User> query(@RequestParam(value = "username", required = false) String username) {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.userDetail.class)
    public User getUser(@PathVariable String id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }
}
