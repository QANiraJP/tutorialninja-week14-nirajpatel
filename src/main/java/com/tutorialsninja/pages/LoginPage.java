package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By myAccount = By.xpath(" //span[contains(text(),'My Account')]");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = (By.xpath("//form[contains(@action,'login')]//input[@type='submit']"));
    By accountText = By.xpath("//div[@class='col-sm-9']/h2[contains(text(),'My Account')]");
    By myAccountText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton = By.xpath("//div[@class='pull-right']//a");


    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);

    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getMyAccountLogoutText() {
        return getTextFromElement(myAccountText);

    }

    public String getMyAccountText() {
        return getTextFromElement(accountText);


    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
