package com.javajunit.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     // Common utility methods for UI tests can be added here
    public void navigateTo(String url) {
        driver.get(url); // Navigate to the specified URL
    }

}