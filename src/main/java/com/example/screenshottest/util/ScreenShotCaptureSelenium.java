package com.example.screenshottest.util;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class ScreenShotCaptureSelenium {
    static int screenshotNum=0;
    static WebDriver driver=null;
    public static void main(String[] args) throws IOException, InterruptedException {
        UrlSelenium selenium = new UrlSelenium(0, null);
        selenium.initDriver();
        selenium.capture("https://kontakt.az/paltaryuyan-toshiba-tw-bl80a2uzss-gumusu/");
        selenium.destroy();
    }
}

