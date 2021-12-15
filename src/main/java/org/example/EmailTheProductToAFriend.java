package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class EmailTheProductToAFriend extends Utils{
    By _FriendEmail = By.id("FriendEmail");
    By _PersonalMessage = By.id("PersonalMessage");
    By _ClickOnSendEmailButton = By.name("send-email");
    public void verifyUserIsOnProductEmailAFriendPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains (loadProp.getProperty("UserIsOnProductEmailAFriendPage")));
    }
    public void userEntersFriendsEmailAndMessage(){
        //Type friends email
        typeText(_FriendEmail, (loadProp.getProperty("email")));
        // type personal message
        typeText(_PersonalMessage, (loadProp.getProperty("Message")));
    }

    public void clickOnSendEmailButton(){
        //User clicks on send email button
        clickOnElement(_ClickOnSendEmailButton);
    }

    public void verifyUserHasSuccessfullySentEmailToAFriend(){
        String actualMessageSentConfirmation = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedMessageSentConfirmation = loadProp.getProperty("MessageSentConfirmation");
        assertEquals(actualMessageSentConfirmation,expectedMessageSentConfirmation);
    }
}
