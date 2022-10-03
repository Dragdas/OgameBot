package com.ogam.ogambot.ogamClient;

import com.ogam.ogambot.logicElements.Price;
import com.ogam.ogambot.ogamClient.enums.Buildings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class OgameNavigation {

    private OgameNavigation(){};
    private static String MAIN_FRAME_NAME = "Hauptframe";
    private static String LEFT_FRAME_NAME = "LeftMenu";
    private static String XPATH_BUILDINGS_NAVIGATION = "//a[contains(text(), \"Budynki\")]";

    private static String XPATH_ELEKTROWNIA = "/html/body/center/table/tbody/tr[5]/td[2]/a";


    public static void goToBuildings(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(LEFT_FRAME_NAME);
        driver.findElement(By.xpath(XPATH_BUILDINGS_NAVIGATION)).click();
        driver.switchTo().defaultContent();

    }

    public static void build(WebDriver driver, Buildings building){
        goToBuildings(driver);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(MAIN_FRAME_NAME);

        List<WebElement> buildingsFound = driver.findElements(By.tagName("a"))
                .stream()
                .filter(webElement -> {
                    String link = webElement.getAttribute("href");
                    if (link == null) return false;
                    return link.contains(building.linkFragment);
                }).toList();

        if(buildingsFound.size()==1)
            buildingsFound.get(0).click();

    }

    public static Price buildingPrice(WebDriver driver, Buildings building){
        goToBuildings(driver);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(MAIN_FRAME_NAME);

        List<WebElement> matchingTableRows = filterBuildingRow(driver, building);

        if(matchingTableRows.size()==0)
            return new Price(0,0,0);

        return retrievePriceInfo(matchingTableRows.get(0));
    }

    private static Price retrievePriceInfo(WebElement buildingRow){
        long metal = 0, cristal = 0, deuter = 0;

        List<String> rawPriceData = buildingRow.findElements(By.tagName("span"))
                .stream()
                .map(WebElement::getText)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();

        for(int i = 0; i<rawPriceData.size() ; i++){
            if(rawPriceData.get(i).contains("Metal")){
                metal = Long.parseLong(rawPriceData.get(i+1));
                i++;
            }
            if(rawPriceData.get(i).contains("Kryształ")){
                cristal = Long.parseLong(rawPriceData.get(i+1));
                i++;
            }
            if(rawPriceData.get(i).contains("Deuter")){
                deuter = Long.parseLong(rawPriceData.get(i+1));
                i++;
            }
        }

        return new Price(metal,cristal,deuter);
    }



    private static List<WebElement> filterBuildingRow(WebDriver driver, Buildings building) {
        return driver.findElements(By.className("l"))
                .stream()
                .filter(webElement -> {

                    long elementsCount = webElement.findElements(By.tagName("a"))
                            .stream()
                            .filter(aTag -> aTag.getText().contains(building.name))
                            .count();
                    return elementsCount > 0;
                }).toList();
    }

}
