package com.gandazhi.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author gandazhi
 * @create 2017-12-20 下午9:38
 **/
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //把数据库里的用户名和密码查出来
//        User user = userMapper.selectByPrimaryKey(1);
//        s = user.getUsername();
        String password = passwordEncoder.encode("123456");
        return new org.springframework.security.core.userdetails.User(s, password,
                true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
