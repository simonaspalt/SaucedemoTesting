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
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div")).getText(),"Swag Labs");
    }

    @Test
    public void itemInCartValidation(){
        //type username
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        //type password
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        //log in button
        _globalDriver.findElement(By.id("login-button")).click();
        //get item name
        String itemName = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText();
        //get item price
        String itemPrice = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div")).getText();
        //click item
        _globalDriver.findElement(By.id("item_4_title_link")).click();
        //assert it is same item
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]")).getText(),itemName);
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[3]")).getText(),itemPrice);
        //add to cart
        _globalDriver.findElement(By.id("add-to-cart")).click();
        // open cart
        _globalDriver.findElement(By.id("shopping_cart_container")).click();
        // asssert it is same item
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText(),itemName);
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText(),itemPrice);

    }

    @Test
    public void PurchaseValidation(){
        //type username
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        //type password
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        //log in button
        _globalDriver.findElement(By.id("login-button")).click();
        //get item name
        String itemName = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText();
        //get item price
        String itemPrice = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div")).getText();
        //click item
        _globalDriver.findElement(By.id("item_4_title_link")).click();
        //add to cart
        _globalDriver.findElement(By.id("add-to-cart")).click();
        // open cart
        _globalDriver.findElement(By.id("shopping_cart_container")).click();
        //click checkout
        _globalDriver.findElement(By.id("checkout")).click();
        //type first name
        _globalDriver.findElement(By.id("first-name")).sendKeys("Belekoks");
        //type last name
        _globalDriver.findElement(By.id("last-name")).sendKeys("Belekaitis");
        //Typo zip/post
        _globalDriver.findElement(By.id("postal-code")).sendKeys("10512");
        //click continue
        _globalDriver.findElement(By.id("continue")).click();
        //assert same item name and price
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText(),itemName);
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText(),itemPrice);
        //click finish
        _globalDriver.findElement(By.id("finish")).click();
        //Assert purchase successful
        Assert.assertEquals(_globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText(), "Thank you for your order!");
        //back to products
        _globalDriver.findElement(By.id("back-to-products")).click();



    }

    @Test
    public void




}
