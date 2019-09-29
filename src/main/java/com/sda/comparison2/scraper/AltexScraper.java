package com.sda.comparison2.scraper;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.services.ProductService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

@Component
public class AltexScraper {
    @Autowired
    private ProductService productService;

    public void altexSearch(String product) {
        System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://altex.ro/cauta/?q=" + product);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> productName = driver.findElements(By.className("Product-name"));
        List<WebElement> productPrices = driver.findElements(By.className("Price-int"));

        for (int k = 0; k < 5; k++) {
            String name = productName.get(k).getText();
            String desc = productName.get(k).getText();
            String price = productPrices.get(k).getText();
            String url = productName.get(k).getAttribute("href");

            Product p2 = new Product();
            p2.setName(name);
            p2.setDescription(desc);
            p2.setPrice(price);
            p2.setUrl(url);

            productService.save(p2);
        }


        driver.close();
    }
}
