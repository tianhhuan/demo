package com.example.demo.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "chatbotconfig")
@Order(value = Integer.MIN_VALUE)
@Component
public class chatbotConfig {
    public static String MESSAGEINDEX = "null";
    public String messageIndex;
    @Bean
    public chatbotConfig getStr(){

        MESSAGEINDEX=messageIndex;
        return this;
    }
}
