package com.javajunit.tests.ui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.javajunit.automation.base.BaseUiTest;
import com.javajunit.automation.pages.ContactListPage;
import com.javajunit.automation.pages.LoginPage;

public class LoginTest extends BaseUiTest {


    @Test
    public void ValidateSuccessfullLoginTest() throws Exception {
        // Simulate a valid login scenario
        LoginPage loginPage = new LoginPage(driver);
        ContactListPage contactListPage = new ContactListPage(driver);
        loginPage.navigateTo(baseUrl);
        loginPage.EnterLoginDetails(username, password);
        loginPage.ClickSubmitButton();
        String expectedTitle = "Contact List";
        Thread.sleep(2000);
        String actualTitle = contactListPage.GetContactListPageTitle();
        assertEquals(expectedTitle, actualTitle);
        contactListPage.ClickOnLogoutButton();
    }

}