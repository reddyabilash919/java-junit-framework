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
        username = (dotenv.get("EMAIL"))!=null?dotenv.get("EMAIL"): System.getenv("EMAIL"); // Get username from environment variable
        password = (dotenv.get("PASSWORD"))!=null?dotenv.get("PASSWORD"): System.getenv("PASSWORD"); // Get password from environment variable
        baseUrl = (dotenv.get("LOGIN_URL"))!=null?dotenv.get("LOGIN_URL"): System.getenv("LOGIN_URL");// Get base URL from environment variable

         if (baseUrl == null || username == null || password == null) {
            throw new RuntimeException("Missing required environment variables");
        }
        System.out.println("execution started");
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Username: " + username);
      
       //System.getProperty("webdriver.chrome.driver")
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless=new", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
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