package com.sda.comparison2.scraper;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmagScraper {

    public static void main(String[] args) {

        search("boxa mica");

        search("casti telefon");
    }

    public static void search(String product) {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //The website that we use for the search
        driver.get("https://www.emag.ro/search/" + product);

        //Gets the search parameters
        WebElement element = driver.findElement(By.id("main-search"));

        //adds the word in the search box
        element.sendKeys("pantaloni");


        //submits the the searched word
        element.submit();
        element.sendKeys(Keys.ENTER);
        System.out.println(driver.getPageSource());

        System.out.println("Page title is: " + driver.getTitle());



        //Gets the product name and short description
        WebElement element1 = driver.findElement(By.className("item-heading"));

        System.out.println(element1.getText());


        //Closes the search query
        driver.close();


    }

}
