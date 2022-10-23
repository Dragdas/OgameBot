package com.ogam.ogambot.ogamClient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

public class OgamClient {


    private static String XPATH_LOGIN = "//*[@id=\"user\"]";
    private static String XPATH_PASSWORD = "//*[@id=\"pass\"]";
    private static String XPATH_LOGG_BUTTON = "//*[@id=\"zaloguj\"]";

    public static void loggin(WebDriver driver){
        driver.get("http://ogam.online/");
        driver.findElement(By.xpath(XPATH_LOGIN)).sendKeys("uuu");
        driver.findElement(By.xpath(XPATH_PASSWORD)).sendKeys("ppp");
        driver.findElement(By.xpath(XPATH_LOGG_BUTTON)).click();
    }

}
