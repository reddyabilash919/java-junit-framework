package com.javajunit.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage {

    // Locators private By addContactButton = By.id("add-contact");

  

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public String GetContactListPageTitle() {
        return driver.findElement(By.xpath("//h1[text()='Contact List']")).getText();
    }

    public String ClickOnLogoutButton() {
        driver.findElement(By.id("logout")).click();
        return driver.getTitle();
    }
}