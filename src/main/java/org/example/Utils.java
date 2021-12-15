package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BrowserManager {

    public static void captureScreenshot(String fileName)
    {
        //convert web driver object to TakeScreenshot
        TakesScreenshot scrShot=((TakesScreenshot) driver);

        //call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File destFile = new File("src\\test\\Screenshots\\"+fileName+currentTimeStamp()+".png");

        //copy file at destination
        try {
            FileUtils.copyFile (SrcFile, destFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        }
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
        return sdf.format(date);
    }
    public static void waitForClickable(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForVisible(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void selectByText(By by, String text){
        Select selectDate = new Select(driver.findElement(by));
        selectDate.selectByVisibleText(text);
    }
    public void selectByValue(By by, String month){
        Select selectMonth = new Select(driver.findElement(by));
        selectMonth.selectByValue(month);
    }
    public void selectByIndex(By by, String year){
        Select selectYear = new Select(driver.findElement(by));
        selectYear.selectByIndex(Integer.parseInt(year));
    }
}
