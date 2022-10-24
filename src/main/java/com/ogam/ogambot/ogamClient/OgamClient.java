package com.ogam.ogambot.ogamClient;

import com.ogam.ogambot.config.CoreApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OgamClient {

    private final CoreApplicationConfiguration config;

    private static String XPATH_LOGIN = "//*[@id=\"user\"]";
    private static String XPATH_PASSWORD = "//*[@id=\"pass\"]";
    private static String XPATH_LOGG_BUTTON = "//*[@id=\"zaloguj\"]";

    public void loggin(WebDriver driver){
        driver.get("http://ogam.online/");
        driver.findElement(By.xpath(XPATH_LOGIN)).sendKeys(config.getUsername());
        driver.findElement(By.xpath(XPATH_PASSWORD)).sendKeys(config.getPassword());
        driver.findElement(By.xpath(XPATH_LOGG_BUTTON)).click();

    }

}
