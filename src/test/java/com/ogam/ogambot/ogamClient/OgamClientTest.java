package com.ogam.ogambot.ogamClient;

import com.ogam.ogambot.ogamClient.enums.Buildings;
import com.ogam.ogambot.config.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OgamClientTest {

    @Autowired
    OgamClient ogamClient;

    @Test
    void loggin() {
        WebDriver driver = WebDriverConfig.getDriver(false);
        ogamClient.loggin(driver);

    }

    @Test
    void navigateToBuildingView(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        ogamClient.loggin(driver);
        OgameNavigation.goToBuildings(driver);
    }

    @Test
    void buildSomething(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        ogamClient.loggin(driver);
        OgameNavigation.build(driver, Buildings.KOP_METALU);
    }

    @Test
    void checkBuildingPrice(){
        WebDriver driver = WebDriverConfig.getDriver(false);
        ogamClient.loggin(driver);
        OgameNavigation.buildingPrice(driver, Buildings.KOP_DEUTERU);

    }


}