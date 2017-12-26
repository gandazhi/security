package com.gandazhi.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author gandazhi
 * @create 2017-12-18 下午9:12
 **/
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timeFilter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("timeFilter耗时:" + (new Date().getTime() - start));
        System.out.println("timeFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy");
    }
}
