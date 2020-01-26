package com.miro.springit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(value = "springit")
@Configuration
public class SpringitConfiguration {

    /**
        This is property for welcome message
     */
    private String welcomeMsg = "Hello world!";

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
