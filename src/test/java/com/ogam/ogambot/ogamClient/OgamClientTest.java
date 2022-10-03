package com.ogam.ogambot.ogamClient;

import com.ogam.ogambot.ogamClient.enums.Buildings;
import com.ogam.ogambot.webDriver.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

class OgamClientTest {

    @Test
    void loggin() {
        WebDriver driver = WebDriverConfig.getDriver(false);
        OgamClient.loggin(driver);

    }

    @Test
    void navigateToBuildingView(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        OgamClient.loggin(driver);
        OgameNavigation.goToBuildings(driver);
    }

    @Test
    void buildSomething(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        OgamClient.loggin(driver);
        OgameNavigation.build(driver, Buildings.KOP_METALU);
    }

    @Test
    void checkBuildingPrice(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        OgamClient.loggin(driver);
        OgameNavigation.buildingPrice(driver, Buildings.KOP_DEUTERU);

    }


}