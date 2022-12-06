package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By desktops = By.xpath("//a[text()='Desktops']");
    By showAllDesktops = By.xpath("//a[text()='Show All Desktops']");
    By desktopsTextMessage = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooks = By.xpath("//a[text()='Laptops & Notebooks']");
    By showAllLaptopsAndNotebooks = By.xpath("//a[text()='Show All Laptops & Notebooks']");
    By laptopsAndNotebooksTextMessage = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.xpath("//a[text()='Components']");
    By showAllComponents = By.xpath("//a[text()='Show All Components']");
    By componentsTextMessage = By.xpath("//h2[contains(text(),'Components')]");

    By currencyDropdown = By.xpath("//span[contains(text(),'Currency')]");

    public void mouseHoverOnDesktopsAndClickShowAllDesktops() {
        mouseHoverToElement(desktops);
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public String getDesktopsTextMessage() {
        return getTextFromElement(desktopsTextMessage);
    }

    public void mouseHoverOnLaptopsAndNotebooksAndClickShowAllLaptopsAndNotebooks() {
        mouseHoverToElement(laptopsAndNotebooks);
        mouseHoverToElementAndClick(showAllLaptopsAndNotebooks);
    }

    public String getLaptopsAndNotebooksTextMessage() {
        return getTextFromElement(laptopsAndNotebooksTextMessage);
    }

    public void mouseHoverOnComponentsAndClickShowAllComponents() {
        mouseHoverToElement(components);
        mouseHoverToElementAndClick(showAllComponents);
    }

    public String getComponentsTextMessage() {
        return getTextFromElement(componentsTextMessage);
    }

    public void changeCurrencyto£(){
        clickOnElement(currencyDropdown);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
}

