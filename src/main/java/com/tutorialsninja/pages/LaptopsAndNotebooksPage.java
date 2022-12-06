package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    By laptop = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooks = By.linkText("Show All Laptops & Notebooks");
    By productsPrice = By.xpath("//p[@class ='price']");
    By currencyTab = By.xpath("//span[contains(text(),'Currency')]");
    By currencyList1 = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By sortBy = By.id("input-sort");
    By MacBook = By.linkText("MacBook");
    By MacBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By cartTab = By.xpath("//button[@id='button-cart']");
    By shoppingCartMsg = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingcartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By getShoppingCartMsg = By.xpath("//div[@id='content']//h1");
    By macBookVerification = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By quantity = By.xpath("//input[contains(@name, 'quantity')]");
    By updateTab = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By modifiedShoppingCartMessage = By.xpath("//div[@id='checkout-cart']/div[1]");
    By checkoutButton = By.xpath("//a[@class='btn btn-primary']");
    By total = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]");
    By checkoutText = By.xpath("//h1[normalize-space()='Checkout']");
    By newCustomer = By.xpath("//div[@class='col-sm-6']/h2[normalize-space()='New Customer']");
    By guestCheckout = By.xpath("//input[@value='guest']");
    By continueTab = By.id("button-account");
    By continueButton = By.id("button-guest");
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By emailField = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By paymentAddress = By.xpath("//input[@id='input-payment-address-1']");
    By paymentCity = By.xpath("//input[@id='input-payment-city']");
    By paymentPostCode = By.xpath("//input[@id='input-payment-postcode']");
    By paymentCountry = By.xpath("//select[@id='input-payment-country']");
    By paymentZone = By.xpath("//select[@id='input-payment-zone']");
    By comments = By.xpath("//textarea[@name='comment']");
    By termsAndConditions = By.name("agree");
    By continueTab1 = By.id("button-payment-method");
    By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");


    public void clickOnLaptop() {
        mouseHoverToElementAndClick(laptop);

    }

    public void clickOnShowAllLaptopsAndNoteBooks() {
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void selectSortByPriceHighToLow() {
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(productsPrice);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(productsPrice);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        Assert.assertEquals(afterSortByPrice,originalProductsPrice);
    }


    public void selectCurrencyTab() {

        clickOnElement(currencyTab);
    }

    public void changeCurrencyToSterling() {
        List<WebElement> currencyList = driver.findElements(currencyList1);
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void selectProductMacBook() {
        clickOnElement(MacBook);
    }

    public String verifyTextMacBook() {
        return getTextFromElement(MacBookText);
    }

    public void clickOnAddToCart() {
        clickOnElement(cartTab);
    }

    public String shoppingCartMessage() {
        return getTextFromElement(shoppingCartMsg);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingcartLink);
    }

    public String verifyShoppingCartText() {
        return getTextFromElement(getShoppingCartMsg);
    }

    public String verifyProductNameMacBook() {
        return getTextFromElement(macBookVerification);
    }

    public void enterQuantity(String qty) {
        sendTextToElement(quantity, qty);
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String modifyShoppingCartMessage() {
        return getTextFromElement(modifiedShoppingCartMessage);
    }

    public String verifyTotal() {

        return getTextFromElement(total);
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
    }

    public String verifyCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String verifyNewCustomer() {
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckOut() {
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueTab);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }

    public void addComments(String text) {
        sendTextToElement(comments, text);
    }

    public void clickonTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab1);
    }

    public String paymentWarningMessage() {
        return getTextFromElement(warningMessage);
    }

    public void enterFirstName(String firstname) {
        sendTextToElement(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterAddress1(String address1) {
        sendTextToElement(paymentAddress, address1);
    }

    public void enterTelephone(String number) {
        sendTextToElement(telephone, number);
    }

    public void enterCity(String cityname) {
        sendTextToElement(paymentCity, cityname);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(paymentPostCode, postcode);
    }

    public void selectCountry() {
        selectByVisibleTextFromDropDown(paymentCountry,"United Kingdom");
    }

    public void selectRegion(){
        selectByVisibleTextFromDropDown(paymentZone,"Aberdeen");
    }

}


