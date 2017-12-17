package com.gandazhi.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author gandazhi
 * @create 2017-12-17 下午2:02
 **/
public class User {

    public interface userSimple {}
    public interface userDetail extends userSimple {}

    private String username;
    private String password;

    @JsonView(userSimple.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(userDetail.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
