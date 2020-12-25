package com.example.demo;

import com.example.demo.Config.chatbotConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//设置启动器
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private chatbotConfig chatbotConfig;
    @Test
    void contextLoads() {
    }
    @Test
    public void configTest(){
        System.out.printf(chatbotConfig.messageIndex);
    }
}
