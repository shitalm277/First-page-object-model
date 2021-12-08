package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils {
    public void verifyUserIsOnTheRegisterSuccessPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("registerresult"));

    }
    public void verifyUserHasSuccessfullyRegistered(){
        //verify expected result is equal to actual result
        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = "Your registration completed";
        Assert.assertEquals(actualRegisterSuccessMessage , expectedRegisterSuccessMessage);
    }
}
