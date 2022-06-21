package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoTest {


    // Get All links from Amazon
//    fetch textsfrom the links
//    remove duplicates
//   sort the texts in alphabetical order
//   Print only text stating with C or D

    @Test(enabled = true)
    public void getLinksFromAmazon() {
        // New way of driver initialization
        String browser = "Chrome";
        System.out.println(String.format("The browser launched is %s", browser));
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        elements.stream().map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .distinct()
                .sorted()
                .filter(s -> s.startsWith("C") || s.startsWith("D"))
                .forEach(System.out::println);

        driver.quit();
    }

    @Test(enabled = false)
    public void createAndSwitchToNewTab() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Rahul Shetty Academy");
    }
}
