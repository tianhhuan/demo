package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = Test.nam )
public class Test {
    @Value("#{chatbotconfig.messageIndex}")
    public  static final String nam="aaa";
}
