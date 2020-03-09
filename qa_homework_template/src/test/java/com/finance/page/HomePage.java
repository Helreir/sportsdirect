package com.finance.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://lt.sportsdirect.com/";

    //*********Web Elements*********
    By men = By.xpath("//a[@href='/mens']");
    By footwearMenu = By.xpath("//a[@href='#collapse4_dsk' and contains(.,'footwear')]");
    By runningShoes = By.xpath("//div[@id='collapse4_dsk']//li[@class='list-group-item']/a[contains(@href,'/running/running-shoes/mens-running-shoes/') and contains(text(),'Running Shoes')]");
    By ad =  By.xpath("(//div[@class='modal-header']/button[@class='close'])[1]");

    //*********Page Methods*********
    //Go to Homepage
    public HomePage sportDirect (){
        driver.get(baseURL);
        click(ad);
        return this;
    }

    //Go to FilterPage
    public FilterPage goToFilterPage (){
        click(men);
        click(footwearMenu);
        click(runningShoes);
        return new FilterPage(driver);
    }
}
