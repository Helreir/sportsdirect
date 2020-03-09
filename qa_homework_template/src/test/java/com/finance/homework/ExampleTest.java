package com.finance.homework;

import com.finance.page.HomePage;
import org.junit.Assert;
import org.junit.Test;


public class ExampleTest extends BaseTest {

    @Test
    public void testSportsDirectTitle() {
//*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        homePage.sportDirect();
        Assert.assertTrue("Title should contain 'The UK’s No 1 Sports Retailer' ",
                driver.getTitle().contains("The UK’s No 1 Sports Retailer")
        );
    }

    @Test
    public void testMensRunningShoes() {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        homePage.sportDirect()
        .goToFilterPage();
                Assert.assertTrue("Url should contain 'mens-running-shoes'",
                driver.getCurrentUrl().contains("/mens-running-shoes")
        );
    }

    @Test
    public void testShoesFilter() {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        homePage.sportDirect()
                .goToFilterPage()
                .filterKarrimorShoes()
                .setPrice();
                Assert.assertTrue("Url should contain Karrimor and price tag",
                driver.getCurrentUrl().contains("Karrimor%7CAPRI%5E20-40")
        );
    }

}
