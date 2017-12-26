package com.gandazhi.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gandazhi.dto.User;
import com.gandazhi.exception.CustomException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * RESTful API demo
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
        System.out.println("进入getUser Controller");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
//        }
        System.out.println(user.toString());
        user.setId(1);
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.toString());
        user.setId(1);
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public String delete(Integer id) {
        throw new CustomException();
    }
}
