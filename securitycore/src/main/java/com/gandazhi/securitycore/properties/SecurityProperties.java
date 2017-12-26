package com.gandazhi.securitycore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security总配置
 * @author gandazhi
 * @create 2017-12-24 下午2:33
 **/
@ConfigurationProperties(prefix = "gandazhi.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}
