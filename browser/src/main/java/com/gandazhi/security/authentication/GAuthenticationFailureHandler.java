package com.gandazhi.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gandazhi.securitycore.properties.LoginType;
import com.gandazhi.securitycore.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证失败
 * @author gandazhi
 * @create 2017-12-26 下午8:40
 **/
@Slf4j
@Component("authenticationFailureHandler")
public class GAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())){
            //配置返回json
            log.error("登录失败");
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(e));
        }else {
            //配置跳转页面
            super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }

    }
}
