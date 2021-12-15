package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils {
    LoadProp loadProp = new LoadProp();
    public void verifyUserIsOnTheRegisterSuccessPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(loadProp.getProperty("UserIsOnRegisterSuccessPage")));

    }
    public void verifyUserHasSuccessfullyRegistered(){
        //verify expected result is equal to actual result
        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = (loadProp.getProperty("RegistrationSuccessMessage"));
        Assert.assertEquals(actualRegisterSuccessMessage , expectedRegisterSuccessMessage);
    }
}
