package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
   LaptopsAndNotebooksPage laptopsAndNotebooksTest = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopsAndNotebooksTest.clickOnLaptop();
        laptopsAndNotebooksTest.clickOnShowAllLaptopsAndNoteBooks();
        laptopsAndNotebooksTest.selectSortByPriceHighToLow();
    }


    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNotebooksTest.selectCurrencyTab();
        laptopsAndNotebooksTest.changeCurrencyToSterling();
        laptopsAndNotebooksTest.clickOnLaptop();
        laptopsAndNotebooksTest.clickOnShowAllLaptopsAndNoteBooks();
        laptopsAndNotebooksTest.selectSortByPriceHighToLow();
        laptopsAndNotebooksTest.selectProductMacBook();
        Assert.assertEquals(laptopsAndNotebooksTest.verifyTextMacBook(), "MacBook", "MacBook Product not display");
        laptopsAndNotebooksTest.clickOnAddToCart();
        Assert.assertTrue(laptopsAndNotebooksTest.shoppingCartMessage().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        laptopsAndNotebooksTest.clickOnShoppingCart();
        Assert.assertTrue(laptopsAndNotebooksTest.verifyShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(laptopsAndNotebooksTest.verifyProductNameMacBook(), "MacBook", "Product name not matched");
        WebElement qty = driver.findElement(By.cssSelector("input[value='1']"));
        qty.clear();
        laptopsAndNotebooksTest.enterQuantity("2");
        laptopsAndNotebooksTest.clickOnUpdateTab();
        Assert.assertTrue(laptopsAndNotebooksTest.modifyShoppingCartMessage().contains("Success: You have modified your shopping cart!"), "Cart not modified");
        Assert.assertEquals(laptopsAndNotebooksTest.verifyTotal(), "£737.45", "Total not matched");
        laptopsAndNotebooksTest.clickOnCheckout();
        Assert.assertEquals(laptopsAndNotebooksTest.verifyCheckoutText(), "Checkout", "not check out");
        Thread.sleep(1000);
        Assert.assertEquals(laptopsAndNotebooksTest.verifyNewCustomer(),"New Customer","correct customer");
        laptopsAndNotebooksTest.clickOnGuestCheckOut();
        laptopsAndNotebooksTest.clickOnContinueButton();
        laptopsAndNotebooksTest.enterFirstName("QAZ");
        laptopsAndNotebooksTest.enterLastName("WSX");
        laptopsAndNotebooksTest.enterEmail("qwerty@gmail.com");
        laptopsAndNotebooksTest.enterTelephone("0987654321");
        laptopsAndNotebooksTest.enterAddress1("19 Jubilee Court");
        laptopsAndNotebooksTest.enterCity("London");
        laptopsAndNotebooksTest.enterPostcode("CR7 6JL");
        laptopsAndNotebooksTest.selectCountry();
        laptopsAndNotebooksTest.selectRegion();
        laptopsAndNotebooksTest.clickOnContinue();
        laptopsAndNotebooksTest.addComments("MacBook");
        laptopsAndNotebooksTest.clickonTermsAndConditions();
        laptopsAndNotebooksTest.clickOnContinueTab();
        Assert.assertEquals(laptopsAndNotebooksTest.paymentWarningMessage(),"Warning: Payment method required!\n×");
    }


}
