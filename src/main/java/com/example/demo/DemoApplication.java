package com.example.demo;

import com.example.demo.Config.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import static com.example.demo.Config.chatbotConfig.MESSAGEINDEX;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Component c= Test.class.getAnnotation(Component.class);

        InvocationHandler invocationHandler= Proxy.getInvocationHandler(c);
        Field field=invocationHandler.getClass().getDeclaredField("memberValues");
        field.setAccessible(true);
        Map meberValues= (Map) field.get(invocationHandler);
        meberValues.put("value","dddddd");
        System.out.printf(c.value());
        SpringApplication.run(DemoApplication.class, args);
        //System.out.printf(MESSAGEINDEX);
    }

}
