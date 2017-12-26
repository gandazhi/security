package com.gandazhi.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gandazhi.securitycore.properties.LoginType;
import com.gandazhi.securitycore.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证成功
 *
 * @author gandazhi
 * @create 2017-12-24 下午8:10
 **/
@Slf4j
@Component("authenticationHandler")
public class GAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //身份信息验证成功
        if (LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())) {
            //配置的是返回JSON
            log.info("登录成功");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            //配置的是跳转到其他页面
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication); //跳转页面
        }

    }
}
