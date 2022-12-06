package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {
    Desktops desktops = new Desktops();
    HomePage homePage = new HomePage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.mouseHoverOnDesktopsAndClickShowAllDesktops();
        desktops.selectFilterAndVerifyRequirement();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.mouseHoverOnDesktopsAndClickShowAllDesktops();
        homePage.changeCurrencyto£();
        desktops.selectSortBy("Name (A - Z)");
        desktops.selectProduct();
        Assert.assertEquals(desktops.getProductTitle(), "HP LP3065", "Title not found");
        desktops.selectRequiredDateFormCalendar("2023", "November", "30");
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"))
                .contains("Success: You have added HP LP3065 to your shopping cart!"), "Product not added to cart");
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@id='content']//h1")), "Shopping Cart  (1.00kg)", "Shopping Cart text not found");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")), "HP LP3065", "Product name not matched");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")), "Delivery Date: 2023-11-30", "Delivery date not matched");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")), "Product 21", "Model not matched");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")), "£74.73", "Total not matched");
    }

}
