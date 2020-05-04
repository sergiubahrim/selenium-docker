package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    public static final int TIME_OUT_IN_SECONDS = 40;

    public static void fill(WebDriver driver, By by, String text) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(driver.findElement(by))).sendKeys(text);
    }

    public static void click(WebDriver driver, By by){
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
    }

    public static void goToUrl(WebDriver driver, String url) {
        if (url!=null) {
            driver.navigate().to(url);
        }
        else{
            System.out.println("URL is not valid");
        }
    }

    public static void waitElement(WebDriver driver, By by) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitElementToBeClickable (WebDriver driver, By by) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitElementToBeInvisible (WebDriver driver, By by) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitAndClick (WebDriver driver, By by){
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();


    }

    public static void inquirySearch (WebDriver driver, By by){
        driver.findElement(by).sendKeys("Test Inquiry Company2");
        driver.findElement(by).sendKeys(Keys.RETURN);
    }

    public static void monitoringSearch (WebDriver driver, By by){
        driver.findElement(by).sendKeys("emag");
        driver.findElement(by).sendKeys(Keys.RETURN);
    }


    public static void riskCheckSearch (WebDriver driver, By by){
        driver.findElement(by).sendKeys("emag");
        driver.findElement(by).sendKeys(Keys.RETURN);
    }



}
