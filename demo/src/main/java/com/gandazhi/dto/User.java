package com.gandazhi.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author gandazhi
 * @create 2017-12-17 下午2:02
 **/
public class User {

    public interface userSimple {}
    public interface userDetail extends userSimple {}

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Integer id;
    @Past
    private Date birthday;

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

    @JsonView(userSimple.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(userSimple.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }
}
