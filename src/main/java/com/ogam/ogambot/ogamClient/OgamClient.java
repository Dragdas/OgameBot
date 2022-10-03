package com.ogam.ogambot.ogamClient;

import com.ogam.ogambot.webDriver.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OgamClient {

    private static String XPATH_LOGIN = "//*[@id=\"user\"]";
    private static String XPATH_PASSWORD = "//*[@id=\"pass\"]";
    private static String XPATH_LOGG_BUTTON = "//*[@id=\"zaloguj\"]";

    public static void loggin(WebDriver driver){
        driver.get("http://ogam.online/");
        driver.findElement(By.xpath(XPATH_LOGIN)).sendKeys("OneManArmy");
        driver.findElement(By.xpath(XPATH_PASSWORD)).sendKeys("gtagta1");
        driver.findElement(By.xpath(XPATH_LOGG_BUTTON)).click();
    }

}
