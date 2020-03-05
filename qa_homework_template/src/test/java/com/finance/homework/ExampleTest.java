package com.finance.homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExampleTest {
    WebDriver driver;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.navigate().to("https://lt.sportsdirect.com/");
    }

    @After
    public void cleanup() {
        driver.close();
    }

    @Test
    public void testSportsDirectTitle() {
        Assert.assertTrue("Title should contain 'The UK’s No 1 Sports Retailer' ",
                driver.getTitle().contains("The UK’s No 1 Sports Retailer")
        );
    }

    @Test
    public void testMenShoes() {
        //Hover and click
        Actions builder = new Actions(driver);
        WebElement men = driver.findElement(By.xpath("//a[@href='/mens']"));
        builder.moveToElement(men).perform();
        waitElement("//ul[@class='Mens']");
        WebElement footwear = driver.findElement(By.xpath("//a[@href='/mens-footwear']"));
        builder.moveToElement(footwear).click().perform();

        waitElement("//span[contains(text(),'featured categories')]");
        WebElement runningShoes = driver.findElement(By.xpath("//h2[contains(.,'mens running shoes')]"));
        runningShoes.click();
        Assert.assertTrue("Url should contain 'mens-running-shoes'",
                driver.getCurrentUrl().contains("/mens-running-shoes")
        );

        //Filter part
        WebElement brandSearchInput = driver.findElement(By.xpath("//input[@id='txtBrandSearch']"));
        brandSearchInput.sendKeys("Karrimor");

        WebElement checkboxF = driver.findElement(By.xpath("//span[@class='SelectableFilter ' and @data-item='ABRA^Karrimor']"));
        checkboxF.click();

        WebElement minPrice = driver.findElement(By.xpath("//input[@id='PriceFilterTextEntryMin']"));
        WebElement maxPrice = driver.findElement(By.xpath("//input[@id='PriceFilterTextEntryMax']"));
        minPrice.sendKeys("20");
        maxPrice.sendKeys("40");

        WebElement goButton = driver.findElement(By.xpath("//input[@id='PriceFilterTextEntryApply']"));
        goButton.click();
        Assert.assertTrue("Url should contain Karrimor and price tag",
                driver.getCurrentUrl().contains("Karrimor%7CAPRI%5E20-40")
        );
    }

    public void waitElement(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
