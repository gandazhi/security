package com.gandazhi.securitycore;

import com.gandazhi.securitycore.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gandazhi
 * @create 2017-12-24 下午2:39
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig {
}
