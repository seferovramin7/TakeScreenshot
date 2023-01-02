package com.example.screenshottest.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UrlSelenium {
    private int screenshotNum = 0;
    private WebDriver driver = null;

    public UrlSelenium(int screenshotNum, WebDriver driver) {
        this.driver = driver;
        this.screenshotNum = screenshotNum;
    }

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        Dimension dimension = new Dimension(300, 900);
        this.driver = new ChromeDriver();
//        this.driver.manage().window().setPosition(new Point(-2600, 0));
        this.driver.manage().window().setSize(dimension);

    }

    public void capture(String site) throws IOException, InterruptedException {
        this.screenshotNum++;
        this.driver.get(site);
        WebElement element = this.driver.findElement(By.xpath("//*[@id=\"universal-modal-bf\"]/div/div/div/button"));
        element.click();
        TimeUnit.SECONDS.sleep(2);
        File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File( Math.floor(Math.random() * 1000) + ".png"));
        System.out.println("Took Screenshot for " + site + " and saved as " + "site" + screenshotNum + ".png");
    }

    public void destroy() {
        this.driver.quit();
    }
}
