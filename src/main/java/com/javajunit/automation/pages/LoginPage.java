package com.javajunit.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    // private By usernameField = By.id("username");
    // private By passwordField = By.id("password");
    // private By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    // Method to enter login details
    public void EnterLoginDetails(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    // Method to click the submit button
    public void ClickSubmitButton() {
        driver.findElement(By.id("submit")).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}