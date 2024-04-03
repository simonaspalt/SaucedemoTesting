import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.color.ICC_ColorSpace;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class SaucedemoTestClass {
    WebDriver _globalDriver;

    private WebDriver globalDriver;
    private WebDriver globalDriver1;
    private WebDriver ;

    @BeforeTest
    public void setupWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.get("https://www.saucedemo.com/");
        _globalDriver.manage().window().maximize();
    }

    @Test
    public void logIn(){
        //type username
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        //type password
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        //log in button
        _globalDriver.findElement(By.id("login-button")).click();
    }



}
