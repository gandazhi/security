package com.gandazhi.security.controller;

import com.gandazhi.security.common.SimpleResponse;
import com.gandazhi.securitycore.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gandazhi
 * @create 2017-12-24 下午1:25
 **/
@Slf4j
@RestController
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache(); //缓存请求,在requireAuthentication取得跳转的是.html还是restful api
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); //用于请求是.html的时候跳转页面
    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 需要验证登录身份,跳到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("跳转的登录链接是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                //判断是不是以.html结尾的,是就跳转到登录页
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowserProperties().getLoginPage());
            }
        }
        //restful api 返回401
        return new SimpleResponse("访问的服务需要身份认证");
    }
}
