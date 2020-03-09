package com.finance.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPage extends BasePage{
    //*********Constructor*********
    public FilterPage(WebDriver driver) {
        super(driver);
    }
    //*********Web Elements*********
    By typeBrand = By.xpath("//input[@id='txtBrandSearch']");
    By checkbox = By.xpath("//span[@class='SelectableFilter ' and @data-item='ABRA^Karrimor']");
    By minPrice = By.xpath("//input[@id='PriceFilterTextEntryMin']");
    By maxPrice = By.xpath("//input[@id='PriceFilterTextEntryMax']");
    By goBtn = By.xpath("//input[@id='PriceFilterTextEntryApply']");

    //Filter shoes
    public FilterPage filterKarrimorShoes (){
        writeText(typeBrand, "Karrimor");
        click(checkbox);
        return this;
    }

    //Set price
    public FilterPage setPrice(){
        writeText(minPrice, "20");
        writeText(maxPrice,"40");
        click(goBtn);
        return this;
    }
}
