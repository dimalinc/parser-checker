package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import static utils.file_utils.html_files_dir;
import static utils.file_utils.writeHtmlToFile;

public class selenium_utils {

    public static String  getUrlWithSelenium(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        long start = System.currentTimeMillis();
        driver.get(url);
        long finish = System.currentTimeMillis();
        String pageTitle = driver.getTitle();
        String browserUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();
        driver.close();

       // writeHtmlToFile(browserUrl.split("/")[browserUrl.split("/").length-1],pageSource);

        return  (finish-start)+"_ms" + pageTitle + " " + browserUrl;
    }

    public static void getSummitItemWithSelenium(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        long start = System.currentTimeMillis();
        driver.get(url);
        WebElement buttonCheckFitElement = driver.findElement(By.id("btnApplicationTab"));
        buttonCheckFitElement.click();
        // until element next present
        WebElement nextLi = driver.findElement(By.className("next-page"));
        while (nextLi.isDisplayed()) {
            // savePageHtml
            String browserUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource();
            writeHtmlToFile(
                    browserUrl.split("/")[browserUrl.split("/").length-2].replace("/","_"),
                    pageSource);
            // next click
            nextLi.click();
        }


        long finish = System.currentTimeMillis();
        driver.close();

    }


}
