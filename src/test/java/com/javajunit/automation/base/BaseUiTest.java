package com.javajunit.automation.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.cdimascio.dotenv.Dotenv;

public class BaseUiTest {

    protected WebDriver driver; // WebDriver instance for UI tests
    protected Dotenv dotenv; // Dotenv instance for environment variables
    protected String username; // Username for login
    protected String password; // Password for login
    protected String baseUrl; // Base URL for the application


    @Before
    // Setup method to be called before each test
    public void setUp() {
        // Initialize WebDriver or other UI test setup here
        dotenv = Dotenv.load(); // Load environment variables from .env file
        username = System.getenv("USERNAME"); // Get username from environment variable
        password = System.getenv("PASSWORD"); // Get password from environment variable
        baseUrl = System.getenv("LOGIN_URL"); // Get base URL from environment variable

         if (baseUrl == null || username == null || password == null) {
            throw new RuntimeException("Missing required environment variables");
        }

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    // Teardown method to be called after each test
    public void tearDown() {
        // Cleanup resources, close browser, etc.

        if (driver != null) {
            driver.quit();
        }
    }

   
}