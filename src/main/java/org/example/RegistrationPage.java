package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Utils {
    By _FirstName = By.id("FirstName");
    By _LastName = By.id("LastName");
    By _DropDownDate = By.name("DateOfBirthDay");
    By _DropDownMonth = By.name("DateOfBirthMonth");
    By _DropDownYear = By.name("DateOfBirthYear");
    By _Email = By.id("Email");
    By _Password = By.id("Password");
    By _ConfirmPassword = By.id("ConfirmPassword");
    By _Newsletter = By.id("Newsletter");
    By _ClickingRegisterButton = By.id("register-button");

    LoadProp loadProp = new LoadProp();

    public void verifyUserIsOnRegisterPage()

    {
        Assert.assertTrue(driver.getCurrentUrl().contains (loadProp.getProperty("UserIsOnRegisterPage")));
    }
    public void userEntersRegistrationDetails()
    {

        typeText(_FirstName, loadProp.getProperty("Name"));//Type name in the firstname textbox.
        typeText(_LastName,loadProp.getProperty("SurName"));//Type surname in the lastname textbox.;
        selectByText(_DropDownDate,loadProp.getProperty("Date"));//select the date
        selectByValue(_DropDownMonth,loadProp.getProperty("Month"));//select the month
        selectByIndex(_DropDownYear,loadProp.getProperty("Year"));//select the year
        String email = loadProp.getProperty("emailone") + currentTimeStamp() + loadProp.getProperty("emailtwo");//type email address to get registered.
        System.out.println(email);
        typeText(_Email,(email));
        waitForVisible(_Newsletter, 20); //wait for 20 secs
        clickOnElement(_Newsletter);
        typeText (_Password, loadProp.getProperty("password"));//type password in the text box
        typeText(_ConfirmPassword, loadProp.getProperty("confirmpassword"));//type confirm password in the text box
    }
    public void clickOnRegisterButton(){
        waitForClickable(_ClickingRegisterButton , 10);//waiting for the button to get clicked
        clickOnElement(_ClickingRegisterButton);//click the button

    }
}
