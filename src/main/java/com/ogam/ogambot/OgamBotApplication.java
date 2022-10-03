package com.ogam.ogambot;

import com.ogam.ogambot.ogamClient.OgamClient;
import com.ogam.ogambot.webDriver.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OgamBotApplication {

    public static void main(String[] args) {

        SpringApplication.run(OgamBotApplication.class, args);


    }

}
