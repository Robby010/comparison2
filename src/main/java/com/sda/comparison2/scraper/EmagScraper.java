package com.sda.comparison2.scraper;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.services.ProductService;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmagScraper {

    @Autowired
    private ProductService productService;

    public void search(String product) {
        System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);


        JavascriptExecutor js = (JavascriptExecutor)driver;
        //The website that we use for the search
        driver.get("https://www.emag.ro/search/" + product);

        //Gets the search parameters
        List<WebElement> productName = driver.findElements(By.className("card-section-mid"));
        List<WebElement> productDescriptions = driver.findElements(By.className("product-title"));
        List<WebElement> productPrices = driver.findElements(By.className("product-new-price"));
        List<WebElement> productUrl = driver.findElements(By.className("js-product-url"));


        for(int i=0; i<5; i++) {
            String name = productName.get(i).getText();
            String desc= productDescriptions.get(i).getText();
            String fullPrice = productPrices.get(i).getText();
            String price = fullPrice.substring(0, fullPrice.length() - 6 );
            String url = productUrl.get(i).getAttribute("href");

            Product p = new Product();
            p.setName(name);
            p.setDescription(desc);
            p.setPrice(price);
            p.setUrl(url);

            productService.save(p);

        }


        //Closes the search query
        driver.close();


    }

}
