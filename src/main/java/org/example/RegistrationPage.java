package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Utils {
    By _FirstName = By.id("FirstName");
    By _LastName = By.id("LastName");
    By _Email = By.id("Email");
    By _Password = By.id("Password");
    By _ConfirmPassword = By.id("ConfirmPassword");
    By _Newsletter = By.id("Newsletter");
    By _ClickingRegisterButton = By.id("register-button");

    public void verifyUserIsOnRegisterPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
    public void userEntersRegistrationDetails(){
        typeText(_FirstName,"Shital");//Type name in the firstname textbox.
        typeText(_LastName, "Mehta");//Type surname in the lastname textbox.
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));//select date
        selectDay.selectByVisibleText("27");
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));//select month
        selectMonth.selectByValue("5");
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));//select year
        selectYear.selectByValue("1989");
        String email = "shitalm7+" + currentTimeStamp() + "@gmail.com";//type email address to get registered.
        System.out.println(email);
        typeText(_Email,(email));
        waitForVisible(_Newsletter, 20); //wait for 20 secs
        clickOnElement(_Newsletter);
        typeText (_Password, "shital.123");//type password in the text box
        typeText(_ConfirmPassword, "shital.123");//type confirm password in the textbox
    }
    public void clickOnRegisterButton(){
        waitForClickable(_ClickingRegisterButton , 10);//waiting for the button to get clicked
        clickOnElement(_ClickingRegisterButton);//click the button

    }
}
